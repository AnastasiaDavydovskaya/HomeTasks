package by.tms.lesson46_task1.repositories;

import by.tms.lesson46_task1.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserRepository implements CrudRepository<User> {

    @PersistenceContext
    private EntityManager entityManager;

    private static final String DELETE_USER = "DELETE FROM User user WHERE id =: id";
    private static final String UPDATE_USER = "UPDATE User user SET login =: login, password =: password WHERE id =: id";
    private static final String SELECT_USERS = "SELECT user FROM User user";
    private static final String SELECT_USERS_BY_ID = "SELECT user FROM User user WHERE user.id =: id";

    @Transactional
    @Override
    public User create(User user) {
        entityManager.persist(user);

        return user;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        Query userQuery = entityManager.createQuery(SELECT_USERS);

        return (List<User>) userQuery.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> findById(Long id) {
        TypedQuery<User> idQuery = entityManager.createQuery(SELECT_USERS_BY_ID, User.class);
        idQuery.setParameter("id", id);

        return Optional.ofNullable(idQuery.getSingleResult());
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Query idQuery = entityManager.createQuery(DELETE_USER);
        idQuery.setParameter("id", id);
    }

    @Transactional
    @Override
    public User update(User user) {
        Query userQuery = entityManager.createQuery(UPDATE_USER);
        userQuery.setParameter("id", user.getId());
        userQuery.setParameter("login", user.getLogin());
        userQuery.setParameter("password", user.getPassword());

        return user;
    }
}
