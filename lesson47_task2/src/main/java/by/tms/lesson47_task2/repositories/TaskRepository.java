package by.tms.lesson47_task2.repositories;

import by.tms.lesson47_task2.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
