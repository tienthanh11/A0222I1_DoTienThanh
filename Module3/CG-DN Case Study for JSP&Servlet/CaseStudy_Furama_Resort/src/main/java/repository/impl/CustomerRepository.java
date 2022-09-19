package repository.impl;

import model.Customer;
import repository.ICustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private final String SELECT_ALL = "SELECT * FROM khach_hang;";
    private final String CREATE_NEW = "INSERT INTO khach_hang (ma_loai_khach, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, " +
            "so_dien_thoai, email, dia_chi)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private final String DELETE_CUSTOMER = "DELETE FROM khach_hang WHERE ma_khach_hang = ?;";
    private final String EDIT_CUSTOMER = "UPDATE khach_hang SET ma_loai_khach = ?, ho_ten = ?, ngay_sinh = ?, " +
            "gioi_tinh = ?, so_cmnd = ?, so_dien_thoai = ?, email = ?, dia_chi = ? " +
            "WHERE ma_khach_hang = ?;";
    private final String SEARCH_CUSTOMER = "SELECT * FROM khach_hang WHERE ho_ten LIKE ?;";

    @Override
    public List<Customer> showCustomer() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Customer customerObj = new Customer();
                customerObj.setCustomer_id(Integer.parseInt(resultSet.getString("ma_khach_hang")));
                customerObj.setCustomer_type_id(Integer.parseInt(resultSet.getString("ma_loai_khach")));
                customerObj.setCustomer_name(resultSet.getString("ho_ten"));
                customerObj.setCustomer_birthday(resultSet.getString("ngay_sinh"));
                customerObj.setCustomer_gender(resultSet.getString("gioi_tinh"));
                customerObj.setCustomer_id_card(resultSet.getString("so_cmnd"));
                customerObj.setCustomer_phone(resultSet.getString("so_dien_thoai"));
                customerObj.setCustomer_email(resultSet.getString("email"));
                customerObj.setCustomer_address(resultSet.getString("dia_chi"));
                customerList.add(customerObj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerList;
    }

    @Override
    public void createCustomer(Customer customer) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_NEW);
            preparedStatement.setInt(1, customer.getCustomer_type_id());
            preparedStatement.setString(2, customer.getCustomer_name());
            preparedStatement.setString(3, customer.getCustomer_birthday());
            preparedStatement.setString(4, customer.getCustomer_gender());
            preparedStatement.setString(5, customer.getCustomer_id_card());
            preparedStatement.setString(6, customer.getCustomer_phone());
            preparedStatement.setString(7, customer.getCustomer_email());
            preparedStatement.setString(8, customer.getCustomer_address());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCustomer(Customer customer) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
            preparedStatement.setInt(1, customer.getCustomer_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editCustomer(Customer customer) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_CUSTOMER);
            preparedStatement.setInt(1, customer.getCustomer_type_id());
            preparedStatement.setString(2, customer.getCustomer_name());
            preparedStatement.setString(3, customer.getCustomer_birthday());
            preparedStatement.setString(4, customer.getCustomer_gender());
            preparedStatement.setString(5, customer.getCustomer_id_card());
            preparedStatement.setString(6, customer.getCustomer_phone());
            preparedStatement.setString(7, customer.getCustomer_email());
            preparedStatement.setString(8, customer.getCustomer_address());
            preparedStatement.setInt(9, customer.getCustomer_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> searchCustomer(String customer_name) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        String new_name = "%" + customer_name + "%";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CUSTOMER);
            preparedStatement.setString(1, new_name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Customer customerObj = new Customer();
                customerObj.setCustomer_id(Integer.parseInt(resultSet.getString("ma_khach_hang")));
                customerObj.setCustomer_type_id(Integer.parseInt(resultSet.getString("ma_loai_khach")));
                customerObj.setCustomer_name(resultSet.getString("ho_ten"));
                customerObj.setCustomer_birthday(resultSet.getString("ngay_sinh"));
                customerObj.setCustomer_gender(resultSet.getString("gioi_tinh"));
                customerObj.setCustomer_id_card(resultSet.getString("so_cmnd"));
                customerObj.setCustomer_phone(resultSet.getString("so_dien_thoai"));
                customerObj.setCustomer_email(resultSet.getString("email"));
                customerObj.setCustomer_address(resultSet.getString("dia_chi"));
                customerList.add(customerObj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerList;
    }
}
