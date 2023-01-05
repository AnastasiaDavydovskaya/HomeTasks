package by.tms.lesson44_task1.services;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {

    T create(T value);
    List<T> findAll();
    T findById(Long id);
    void delete(Long id);
    T update(T value);
}
