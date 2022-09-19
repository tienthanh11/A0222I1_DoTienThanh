package repository;

import model.Category;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private DBConnection dbConnection = new DBConnection();

    private static final String INSERT_PRODUCT = "insert into `product`(`name`, price, quantity,color,description,category) " +
            "values(?,?,?,?,?,?)";
    private static final String FIND_PRODUCT = "select * from `product` p join `category` c on p.category=c.id " +
            "where p.id=?;";
    //    private static final String FIND_ALL_PRODUCT = "select * from `product` p join `category` c on p.category=c.id ;";
    private static final String FIND_ALL_PRODUCT = "select SQL_CALC_FOUND_ROWS * from `product` p " +
            "join `category` c on p.category=c.id limit ?,?;";
    private static final String DELETE_BY_ID = "delete from `product` where id=?";
    private static final String UPDATE_PRODUCT = "update `product` set name=?,price=?,quantity=?,color=?,description=?,category=? " +
            "where id=?";
    private static final String SEARCH_BY_NAME = "select * from `product` p join `category` c on p.category=c.id " +
            "where p.name like concat('%',?,'%')";
    private static final String SEARCH_BY_PRICE = "select * from `product` p join `category` c on p.category=c.id " +
            "where p.price like concat('%',?,'%')";
    private static final String SEARCH_BY_QUANTITY = "select * from `product` p join `category` c on p.category=c.id " +
            "where p.quantity like concat('%',?,'%')";
    private static final String SEARCH_BY_COLOR = "select * from `product` p join `category` c on p.category=c.id " +
            "where p.color like concat('%',?,'%')";
    private static final String SEARCH_BY_CATEGORY = "select * from `product` p join `category` c on p.category=c.id " +
            "where c.name like concat('%',?,'%')";
    private static final String FIND_LIST_CATEGORY = "select * from category";
    private int noOfRecords;

    public ProductRepository() {
    }

    @Override
    public void insertProduct(Product product) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_PRODUCT)) {
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setString(5, product.getDescription());
            statement.setInt(6, product.getCode_category());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product selectProduct(int id) {
        return null;
    }

    @Override
    public List<Product> selectAllProduct(int offset, int noOfRecords) {
        List<Product> products = new ArrayList<>();
        ResultSet resultSet = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_PRODUCT)) {
            statement.setInt(1, offset);
            statement.setInt(2, noOfRecords);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                double price = resultSet.getDouble(3);
                int quantity = resultSet.getInt(4);
                String color = resultSet.getString(5);
                String description = resultSet.getString(6);
                int code_category = resultSet.getInt(7);
                String category = resultSet.getString(9);
                products.add(new Product(id, name, price, quantity, color, description, code_category, category));
            }
            resultSet = statement.executeQuery("SELECT FOUND_ROWS()");
            if (resultSet.next()) {
                this.noOfRecords = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public boolean deleteProduct(int id) {
        boolean deleteRow;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, id);
            deleteRow = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deleteRow;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        boolean updateRow;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT)) {
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setString(5, product.getDescription());
            statement.setInt(6, product.getCode_category());
            statement.setInt(7, product.getId());
            updateRow = statement.executeUpdate() > 0;
        }
        return updateRow;
    }

    @Override
    public List<Product> findProduct(String s) {
        return null;
    }

    @Override
    public List<Product> search(String key, String value) {
        List<Product> products = new ArrayList<>();
        ResultSet resultSet = null;
        String query = null;
        switch (key) {
            case "1":
                query = SEARCH_BY_NAME;
                break;
            case "2":
                query = SEARCH_BY_PRICE;
                break;
            case "3":
                query = SEARCH_BY_QUANTITY;
                break;
            case "4":
                query = SEARCH_BY_COLOR;
                break;
            case "5":
                query = SEARCH_BY_CATEGORY;
                break;
            default:
                return null;
        }
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, value);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                double price = resultSet.getDouble(3);
                int quantity = resultSet.getInt(4);
                String color = resultSet.getString(5);
                String description = resultSet.getString(6);
                String category = resultSet.getString(9);
                products.add(new Product(id, name, price, quantity, color, description, category));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public List<Category> findListCategory() {
        List<Category> categoryList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_LIST_CATEGORY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                categoryList.add(new Category(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categoryList;
    }

    @Override
    public int getNoOfRecords() {
        return noOfRecords;
    }
}
