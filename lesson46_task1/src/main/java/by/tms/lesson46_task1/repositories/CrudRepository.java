package by.tms.lesson46_task1.repositories;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {

    T create(T value);
    List<T> findAll();
    Optional<T> findById(Long id);
    void delete(Long id);
    T update(T value);
}
