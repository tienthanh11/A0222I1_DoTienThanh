package service;

import model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> showEmployee();

    boolean createEmployee(Employee employee);

    boolean deleteEmployee(Employee employee);

    boolean editEmployee(Employee employee);

    List<Employee> searchEmployee(String employee_name);
}
