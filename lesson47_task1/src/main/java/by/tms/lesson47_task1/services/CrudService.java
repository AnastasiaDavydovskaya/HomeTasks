package by.tms.lesson47_task1.services;

import java.util.List;

public interface CrudService<T> {

    T create(T value);
    List<T> findAll();
    T findById(Long id);
    void deleteById(Long id);
    T update(T value);
}
