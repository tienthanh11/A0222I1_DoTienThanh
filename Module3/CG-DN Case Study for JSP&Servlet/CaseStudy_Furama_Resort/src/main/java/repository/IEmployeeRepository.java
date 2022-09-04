package repository;

import model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> showEmployee();

    void createEmployee(Employee employee);

    void deleteEmployee(Employee employee);

    void editEmployee(Employee employee);

    List<Employee> searchEmployee(String employee_name);
}
