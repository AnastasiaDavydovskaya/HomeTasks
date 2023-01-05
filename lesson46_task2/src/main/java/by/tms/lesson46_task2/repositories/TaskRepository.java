package by.tms.lesson46_task2.repositories;

import by.tms.lesson46_task2.entities.Task;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@AllArgsConstructor
@Repository
public class TaskRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private static final String UPDATE_STATUS = "UPDATE Task task SET status =: status WHERE id =: id";
    private static final String SELECT_TASKS = "SELECT task FROM Task task";

    @Transactional
    public void addTask(Task task) {
        entityManager.persist(task);
    }

    @Transactional
    public void changeStatusOfTask(Task task) {
        Query query = entityManager.createQuery(UPDATE_STATUS);
        query.setParameter("id", task.getId());
        query.setParameter("status", task.getStatus().name());
    }

    @Transactional(readOnly = true)
    public List<Task> readTasks() {
        TypedQuery<Task> query = entityManager.createQuery(SELECT_TASKS, Task.class);

        return query.getResultList();
    }
}
