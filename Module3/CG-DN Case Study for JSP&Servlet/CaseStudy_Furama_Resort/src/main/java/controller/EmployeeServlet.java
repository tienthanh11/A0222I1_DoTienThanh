package controller;

import model.Employee;
import service.IEmployeeService;
import service.impl.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"/index_employee"})
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService employeeService = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            default:
                getList(request, response);
                break;
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/create_employee.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/delete_employee.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/edit_employee.jsp");
        requestDispatcher.forward(request, response);
    }

    private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeService.showEmployee();
        if (employeeList == null) {
            request.setAttribute("msg", "No data to display ");
        } else {
            request.setAttribute("employee", employeeList);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/employee_interaction.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            case "edit":
                editEmployee(request, response);
                break;
            case "search":
                searchEmployee(request, response);
                break;
            default:
                break;
        }

    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int degree = Integer.parseInt(request.getParameter("degree"));
        int position = Integer.parseInt(request.getParameter("position"));
        int division = Integer.parseInt(request.getParameter("division"));
        Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, degree, position, division);
        boolean isCreated = employeeService.createEmployee(employee);
        if (isCreated) {
            request.setAttribute("msg", "Successful");
        } else {
            request.setAttribute("msg", "Unsuccessful");
            request.setAttribute("msgName", "Invalid name");
            request.setAttribute("msgbirth", "Invalid birth");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/create_employee.jsp");
            requestDispatcher.forward(request, response);
        }
        request.setAttribute("employee", employeeService.showEmployee());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/employee_interaction.jsp");
        requestDispatcher.forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        for(Employee employee : employeeService.showEmployee()) {
            if(employee.getEmployee_id() == id) {
                employeeService.deleteEmployee(employee);
            } else {
                request.setAttribute("msgdelete", "id can't found in list");
            }
        }
        request.setAttribute("employee", employeeService.showEmployee());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/employee_interaction.jsp");
        requestDispatcher.forward(request, response);
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int degree = Integer.parseInt(request.getParameter("degree"));
        int position = Integer.parseInt(request.getParameter("position"));
        int division = Integer.parseInt(request.getParameter("division"));
        Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, degree, position, division);
        employeeService.editEmployee(employee);
        request.setAttribute("employee", employeeService.showEmployee());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/employee_interaction.jsp");
        requestDispatcher.forward(request, response);
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        request.setAttribute("employee", employeeService.searchEmployee(name));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/employee_interaction.jsp");
        requestDispatcher.forward(request, response);
    }
}
