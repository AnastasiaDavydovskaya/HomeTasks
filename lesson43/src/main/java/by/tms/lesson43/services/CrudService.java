package by.tms.lesson43.services;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {

    T create(T value);
    List<T> findAll();
    Optional<T> findById(Long id);
    void delete(Long id);
}
