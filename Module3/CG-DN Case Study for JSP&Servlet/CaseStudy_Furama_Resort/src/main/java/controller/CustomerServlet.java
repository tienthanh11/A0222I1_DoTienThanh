package controller;

import model.Customer;
import service.ICustomerService;
import service.impl.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/index_customer"})
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
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
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/create_customer.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/delete_customer.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/edit_customer.jsp");
        requestDispatcher.forward(request, response);
    }

    private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerService.showCustomer();
        if (customerList == null) {
            request.setAttribute("msg", "No data to display ");
        } else {
            request.setAttribute("customer", customerList);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/customer_interaction.jsp");
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
                createCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "search":
                searchCustomer(request, response);
                break;
            default:
                break;
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int type_customer = Integer.parseInt(request.getParameter("type_customer"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, type_customer, name, birthday, gender, idCard, phone, email, address);
        customerService.createCustomer(customer);
        request.setAttribute("customer", customerService.showCustomer());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/customer_interaction.jsp");
        requestDispatcher.forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        for(Customer customer : customerService.showCustomer()) {
            if(customer.getCustomer_id() == id) {
                customerService.deleteCustomer(customer);
            }
        }
        request.setAttribute("customer", customerService.showCustomer());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/customer_interaction.jsp");
        requestDispatcher.forward(request, response);
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int type_customer = Integer.parseInt(request.getParameter("type_customer"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, type_customer, name, birthday, gender, idCard, phone, email, address);
        customerService.editCustomer(customer);
        request.setAttribute("customer", customerService.showCustomer());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/customer_interaction.jsp");
        requestDispatcher.forward(request, response);
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        request.setAttribute("customer", customerService.searchCustomer(name));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/customer_interaction.jsp");
        requestDispatcher.forward(request, response);
    }
}
