package service;

import java.util.List;
import java.util.Map;

public interface IBaseService<E> {
    List<E> findAll(int limit,int offset);

    Map<String, String> save(E e);

    void removeById(String id);
    int count();

    List<E> findBy(String name, String stage, String dateIn, String dateOut);
}
