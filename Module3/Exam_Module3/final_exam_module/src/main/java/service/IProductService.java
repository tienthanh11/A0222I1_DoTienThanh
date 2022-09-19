package service;

import model.Category;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    void insertProduct(Product product);

    Product selectProduct(int id);

    List<Product> selectAllProduct(int offset, int noOfRecords);

    boolean deleteProduct(int id);

    boolean updateProduct(Product product) throws SQLException;

    List<Product> findProduct(String s);

    List<Product> search(String key, String value);

    List<Category> findListCategory();

    int getNoOfRecords();
}
