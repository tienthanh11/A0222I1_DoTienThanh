package repository.impl;

import model.Product;
import repository.BaseRepository;
import repository.IProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static final String SELECT_ALL = "select * from product;";
    private static final String INSERT = "insert into product(product_name, product_price, product_quantity, product_color, product_describe, category_id) " +
            "values (?,?,?,?,?,?);";
    private static final String DELETE = "delete from product where product_id = ?;";
    private static final String UPDATE = "update product set product_name = ?, product_price = ?, product_quantity = ?, product_color = ?, product_describe = ?, category_id = ?  " +
            "where product_id = ?;";
    private static final String SELECT_BY_ID = "select * from product where product_id =?";
    private static final String SEARCH = "select * from product where product_name like ?;";

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("product_id");
                String name = resultSet.getString("product_name");
                double price = resultSet.getDouble("product_price");
                int quantity = resultSet.getInt("product_quantity");
                String color = resultSet.getString("product_color");
                String describe = resultSet.getString("product_describe");
                int categoryId = resultSet.getInt("category_id");
                productList.add(new Product(id, name, price, quantity, color, describe, categoryId));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public boolean insert(Product product) {
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescribe());
            preparedStatement.setInt(6, product.getCategoryId());
            int update = preparedStatement.executeUpdate();
            if (update != 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            int update = preparedStatement.executeUpdate();
            if (update != 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean update(Product product) {
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescribe());
            preparedStatement.setInt(6, product.getCategoryId());
            preparedStatement.setInt(7, product.getId());
            int update = preparedStatement.executeUpdate();
            if (update != 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("product_name");
                double price = resultSet.getDouble("product_price");
                int quantity = resultSet.getInt("product_quantity");
                String color = resultSet.getString("product_color");
                String describe = resultSet.getString("product_describe");
                int categoryId = resultSet.getInt("category_id");
                product = new Product(id, name, price, quantity, color, describe, categoryId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("product_id");
                String nameProduct = resultSet.getString("product_name");
                double price = resultSet.getDouble("product_price");
                int quantity = resultSet.getInt("product_quantity");
                String color = resultSet.getString("product_color");
                String describe = resultSet.getString("product_describe");
                int categoryId = resultSet.getInt("category_id");
                productList.add(new Product(id, nameProduct, price, quantity, color, describe, categoryId));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }
}
