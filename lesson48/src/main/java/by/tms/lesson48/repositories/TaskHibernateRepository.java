package by.tms.lesson48.repositories;

import by.tms.lesson48.entities.Task;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class TaskHibernateRepository {

    private final SessionFactory sessionFactory;

    public void save(Task task) {

        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(task);
            tx.commit();
        } catch (Exception e) {
            throw new RuntimeException("Cannot save user");
        }
    }

    public List<Task> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT task FROM Task task", Task.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Cannot find any users");
        }
    }

}
