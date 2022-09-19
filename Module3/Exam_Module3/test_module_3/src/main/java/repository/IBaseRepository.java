package repository;

import java.util.List;

public interface IBaseRepository<E> {
    List<E> findAll(int limit,int offset);

    void save(E e);

    List<E> findBy(String name, String stage, String dateIn, String dateOut);

    int count();

    void removeById(String id);
}
