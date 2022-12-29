package by.tms.lesson47_task1.repositories;

import by.tms.lesson47_task1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
