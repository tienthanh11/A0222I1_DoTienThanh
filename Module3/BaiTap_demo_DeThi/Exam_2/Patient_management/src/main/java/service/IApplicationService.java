package service;

import model.Category;
import model.Object;

import java.sql.SQLException;
import java.util.List;

public interface IApplicationService {
    boolean insertObject(Object object);

    Object selectObject(String id);

    List<Object> selectAllObject(int offset, int noOfRecords);

    boolean deleteObject(String id);

    boolean updateObject(Object object);

    List<Object> findObject(String s);

    List<Object> search(String key, String value);

    List<Category> findListCategory();

    int getNoOfRecords();

}
