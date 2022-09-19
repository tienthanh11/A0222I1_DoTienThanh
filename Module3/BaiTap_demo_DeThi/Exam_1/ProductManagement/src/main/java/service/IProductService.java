package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    boolean insert(Product product);

    boolean delete(Integer id);

    boolean update(Product product);

    Product findById(Integer id);

    List<Product> search(String name);
}
