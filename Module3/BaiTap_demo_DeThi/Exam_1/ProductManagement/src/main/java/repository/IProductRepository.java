package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    boolean insert(Product product);

    boolean delete(int id);

    boolean update(Product product);

    Product findById(int id);

    List<Product> search(String name);
}
