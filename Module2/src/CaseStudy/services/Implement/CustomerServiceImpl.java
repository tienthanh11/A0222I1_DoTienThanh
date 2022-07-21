package CaseStudy.services.Implement;

import CaseStudy.models.Customer;
import CaseStudy.services.CustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static List<Customer> customerList = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void displayCustomer() {
        for(Customer customer: customerList) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void addNewCustomer() {
        System.out.println("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter full name: ");
        String fullName = scanner.nextLine();
        System.out.println("Enter date of birth: ");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.println("Enter identity card number: ");
        String identityCardNumber = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Enter customer type: ");
        String customerType = scanner.nextLine();
        System.out.println("Enter customer address");
        String customerAddress = scanner.nextLine();

        Customer customer = new Customer(id, fullName, dateOfBirth, gender, identityCardNumber, phoneNumber, email, customerType, customerAddress);
        customerList.add(customer);
        System.out.println("Successfully added new customer");
    }

    @Override
    public void editCustomer() {
        System.out.println("Enter id to edit: ");
        int edit = Integer.parseInt(scanner.nextLine());

        for (Customer customer : customerList) {
            if (customer.getId() == edit) {
                System.out.println(customer.toString());
                int choose;
                do {
                    System.out.println("*----- Edit customer information -----*");
                    System.out.println("* 1. Enter new full name.             *");
                    System.out.println("* 2. Enter new date of birth.         *");
                    System.out.println("* 3. Enter new gender.                *");
                    System.out.println("* 4. Enter new identity card number.  *");
                    System.out.println("* 5. Enter new phone number.          *");
                    System.out.println("* 6. Enter new email.                 *");
                    System.out.println("* 7. Enter new customer type.         *");
                    System.out.println("* 8. Enter new customer address.      *");
                    System.out.println("* 9. Exit.                            *");
                    System.out.println(" ------------------------------------ ");
                    choose = Integer.parseInt(scanner.nextLine());
                    switch (choose) {
                        case 1:
                            System.out.println("Enter new full name: ");
                            String editName = scanner.nextLine();
                            customer.setFullName(editName);
                            break;
                        case 2:
                            System.out.println("Enter new date of birth: ");
                            String editBirth = scanner.nextLine();
                            customer.setDataOfBirth(editBirth);
                            break;
                        case 3:
                            System.out.println("Enter new gender: ");
                            String editGender = scanner.nextLine();
                            customer.setGender(editGender);
                            break;
                        case 4:
                            System.out.println("Enter new identity card number: ");
                            String editCMND = scanner.nextLine();
                            customer.setIdentityCardNumber(editCMND);
                            break;
                        case 5:
                            System.out.println("Enter new phone number: ");
                            String editPhone = scanner.nextLine();
                            customer.setPhoneNumber(editPhone);
                            break;
                        case 6:
                            System.out.println("Enter new email: ");
                            String editEmail = scanner.nextLine();
                            customer.setEmail(editEmail);
                            break;
                        case 7:
                            System.out.println("Enter new customer type: ");
                            String editCustomerType = scanner.nextLine();
                            customer.setCustomerType(editCustomerType);
                            break;
                        case 8:
                            System.out.println("Enter new customer address: ");
                            String editAddress = scanner.nextLine();
                            customer.setCustomerAddress(editAddress);
                            break;
                        case 9:
                            break;
                    }
                } while (choose != 9);
            }
        }
    }
}
