package repository.impl;

import model.Employee;
import repository.IEmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private final String SELECT_ALL = "SELECT * FROM nhan_vien;";
    private final String CREATE_NEW = "INSERT INTO nhan_vien (ho_ten , ngay_sinh, so_cmnd, luong, so_dien_thoai, " +
            "email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private final String DELETE_EMPLOYEE = "DELETE FROM nhan_vien WHERE ma_nhan_vien = ?;";
    private final String EDIT_EMPLOYEE = "UPDATE nhan_vien SET ho_ten = ?, ngay_sinh = ?, so_cmnd = ?, luong = ?," +
            "so_dien_thoai = ?, email = ?, dia_chi = ?, ma_vi_tri = ?, ma_trinh_do = ?, ma_bo_phan = ? " +
            "WHERE ma_nhan_vien = ?;";
    private final String SEARCH_EMPLOYEE = "SELECT * FROM nhan_vien WHERE ho_ten LIKE ?;";

    @Override
    public List<Employee> showEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employeeObj = new Employee();
                employeeObj.setEmployee_id(Integer.parseInt(resultSet.getString("ma_nhan_vien")));
                employeeObj.setEmployee_name(resultSet.getString("ho_ten"));
                employeeObj.setEmployee_birthday(resultSet.getString("ngay_sinh"));
                employeeObj.setEmployee_id_card(resultSet.getString("so_cmnd"));
                employeeObj.setEmployee_salary(Double.parseDouble(resultSet.getString("luong")));
                employeeObj.setEmployee_phone(resultSet.getString("so_dien_thoai"));
                employeeObj.setEmployee_email(resultSet.getString("email"));
                employeeObj.setEmployee_address(resultSet.getString("dia_chi"));
                employeeObj.setPosition_id(Integer.parseInt(resultSet.getString("ma_vi_tri")));
                employeeObj.setEducation_degree_id(Integer.parseInt(resultSet.getString("ma_trinh_do")));
                employeeObj.setDivision_id(Integer.parseInt(resultSet.getString("ma_bo_phan")));
                employeeList.add(employeeObj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }

    @Override
    public void createEmployee(Employee employee) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_NEW);
            preparedStatement.setString(1, employee.getEmployee_name());
            preparedStatement.setString(2, employee.getEmployee_birthday());
            preparedStatement.setString(3, employee.getEmployee_id_card());
            preparedStatement.setDouble(4, employee.getEmployee_salary());
            preparedStatement.setString(5, employee.getEmployee_phone());
            preparedStatement.setString(6, employee.getEmployee_email());
            preparedStatement.setString(7, employee.getEmployee_address());
            preparedStatement.setInt(8, employee.getPosition_id());
            preparedStatement.setInt(9, employee.getEducation_degree_id());
            preparedStatement.setInt(10, employee.getDivision_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setInt(1, employee.getEmployee_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editEmployee(Employee employee) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_EMPLOYEE);
            preparedStatement.setString(1, employee.getEmployee_name());
            preparedStatement.setString(2, employee.getEmployee_birthday());
            preparedStatement.setString(3, employee.getEmployee_id_card());
            preparedStatement.setDouble(4, employee.getEmployee_salary());
            preparedStatement.setString(5, employee.getEmployee_phone());
            preparedStatement.setString(6, employee.getEmployee_email());
            preparedStatement.setString(7, employee.getEmployee_address());
            preparedStatement.setInt(8, employee.getPosition_id());
            preparedStatement.setInt(9, employee.getEducation_degree_id());
            preparedStatement.setInt(10, employee.getDivision_id());
            preparedStatement.setInt(11, employee.getEmployee_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> searchEmployee(String employee_name) {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        String new_name = "%" + employee_name + "%";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_EMPLOYEE);
            preparedStatement.setString(1, new_name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employeeObj = new Employee();
                employeeObj.setEmployee_id(Integer.parseInt(resultSet.getString("ma_nhan_vien")));
                employeeObj.setEmployee_name(resultSet.getString("ho_ten"));
                employeeObj.setEmployee_birthday(resultSet.getString("ngay_sinh"));
                employeeObj.setEmployee_id_card(resultSet.getString("so_cmnd"));
                employeeObj.setEmployee_salary(Double.parseDouble(resultSet.getString("luong")));
                employeeObj.setEmployee_phone(resultSet.getString("so_dien_thoai"));
                employeeObj.setEmployee_email(resultSet.getString("email"));
                employeeObj.setEmployee_address(resultSet.getString("dia_chi"));
                employeeObj.setPosition_id(Integer.parseInt(resultSet.getString("ma_vi_tri")));
                employeeObj.setEducation_degree_id(Integer.parseInt(resultSet.getString("ma_trinh_do")));
                employeeObj.setDivision_id(Integer.parseInt(resultSet.getString("ma_bo_phan")));
                employeeList.add(employeeObj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }
}
