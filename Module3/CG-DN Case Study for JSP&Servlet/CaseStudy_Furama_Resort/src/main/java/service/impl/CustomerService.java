package service.impl;

import model.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository repository = new CustomerRepository();

    @Override
    public List<Customer> showCustomer() {
        try {
            List<Customer> customerList = repository.showCustomer();
            if(customerList.size() == 0) {
                return null;
            }
            return customerList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean createCustomer(Customer customer) {
        if (checkCustomer(customer)) {
            repository.createCustomer(customer);
            return true;
        } else {
            System.out.println("error");
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        if (checkCustomer(customer)) {
            repository.deleteCustomer(customer);
            return true;
        } else {
            System.out.println("error");
        }
        return false;
    }

    @Override
    public boolean editCustomer(Customer customer) {
        if (checkCustomer(customer)) {
            repository.editCustomer(customer);
            return true;
        } else {
            System.out.println("error");
        }
        return false;
    }

    @Override
    public List<Customer> searchCustomer(String customer_name) {
        return repository.searchCustomer(customer_name);
    }

    public boolean checkCustomer(Customer customer) {
        if(customer.getCustomer_id() < 0) {
            return false;
        }
        if (!customer.getCustomer_name().matches("^[KH]{1}+\\-[0-9]{4}+$")) {
            return false;
        }
        if (!customer.getCustomer_phone().matches("^(090|091|8490|8491)\\d{7}+$")) {
            return false;
        }
        if(!customer.getCustomer_id_card().matches("^[0-9]{9,12}+$")){
            return false;
        }
        return true;
    }
}
