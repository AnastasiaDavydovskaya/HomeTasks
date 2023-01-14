package by.tms.lesson49.repositories;

import by.tms.lesson49.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
