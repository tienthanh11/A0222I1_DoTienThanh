package repository;

import java.util.List;

public interface ITypeRepository<E> {
    List<E> findAll();
}
