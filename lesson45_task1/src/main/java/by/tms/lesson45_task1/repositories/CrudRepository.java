package by.tms.lesson45_task1.repositories;

import java.util.List;

public interface CrudRepository<T> {

    T create(T value);
    List<T> findAll();
    T findById(Long id);
    void delete(Long id);
    T update(T value);
}
