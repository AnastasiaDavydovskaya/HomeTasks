package by.tms.lesson49.repositories;

import by.tms.lesson49.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
