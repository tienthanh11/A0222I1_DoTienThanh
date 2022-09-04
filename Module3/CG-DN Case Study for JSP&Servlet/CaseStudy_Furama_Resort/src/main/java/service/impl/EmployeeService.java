package service.impl;

import model.Employee;
import repository.IEmployeeRepository;
import repository.impl.EmployeeRepository;
import service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private IEmployeeRepository repository = new EmployeeRepository();

    @Override
    public List<Employee> showEmployee() {
        try {
            List<Employee> employeeList = repository.showEmployee();
            if(employeeList.size() == 0) {
                return null;
            }
            return employeeList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean createEmployee(Employee employee) {
        if(checkEmployee(employee)) {
            this.repository.createEmployee(employee);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        if(checkEmployee(employee)) {
            this.repository.deleteEmployee(employee);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean editEmployee(Employee employee) {
        if(checkEmployee(employee)) {
            this.repository.editEmployee(employee);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Employee> searchEmployee(String employee_name) {
        return repository.searchEmployee(employee_name);
    }

    public boolean checkEmployee(Employee employee) {
        if(employee.getEmployee_id() < 0) {
            return false;
        }
        if(employee.getEmployee_name().equals("")) {
            return false;
        }
        if(employee.getEmployee_salary() < 0) {
            return false;
        }
        if(!employee.getEmployee_birthday().matches("^([0-9A-Z]{2})\\-([0-9]{2})\\-([0-9]{4})")) {
            return false;
        }
        if(!employee.getEmployee_email().matches("^[\\w_]+\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
            return false;
        }
        return true;
    }
}
