package repository;

import model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> showCustomer();

    void createCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    void editCustomer(Customer customer);

    List<Customer> searchCustomer(String customer_name);
}
