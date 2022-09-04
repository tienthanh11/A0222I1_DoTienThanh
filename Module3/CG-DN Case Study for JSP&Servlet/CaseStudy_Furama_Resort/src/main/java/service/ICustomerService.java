package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> showCustomer();

    boolean createCustomer(Customer customer);

    boolean deleteCustomer(Customer customer);

    boolean editCustomer(Customer customer);

    List<Customer> searchCustomer(String customer_name);
}
