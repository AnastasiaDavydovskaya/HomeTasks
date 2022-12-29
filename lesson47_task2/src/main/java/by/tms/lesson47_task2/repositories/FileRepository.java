package by.tms.lesson47_task2.repositories;

import by.tms.lesson47_task2.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FileRepository extends JpaRepository<File, Long> {

    @Query("SELECT file FROM File file WHERE file.idTask = :idTask")
    File findByIdTask(@Param("idTask") Long idTask);
}
