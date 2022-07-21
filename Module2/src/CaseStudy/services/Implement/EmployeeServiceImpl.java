package CaseStudy.services.Implement;

import CaseStudy.models.Employee;
import CaseStudy.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private static List<Employee> employeeList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void displayEmployee() {
        for(Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }

    @Override
    public void addNewEmployee() {
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
        System.out.println("Enter level: ");
        String level = scanner.nextLine();
        System.out.println("Enter position: ");
        String position = scanner.nextLine();
        System.out.println("Enter salary: ");
        int salary = Integer.parseInt(scanner.nextLine());
        Employee employee = new Employee(id, fullName, dateOfBirth, gender, identityCardNumber, phoneNumber, email, level, position, salary);
        employeeList.add(employee);
        System.out.println("Successfully added new employee");
    }
    @Override
    public void editEmployee() {
        System.out.println("Enter id to edit: ");
        int edit = Integer.parseInt(scanner.nextLine());

        for (Employee employee : employeeList) {
            if (employee.getId() == edit) {
                System.out.println(employee.toString());
                int choose;
                do {
                    System.out.println("*----- Edit employee information -----*");
                    System.out.println("* 1. Enter new full name.             *");
                    System.out.println("* 2. Enter new date of birth.         *");
                    System.out.println("* 3. Enter new gender.                *");
                    System.out.println("* 4. Enter new identity card number.  *");
                    System.out.println("* 5. Enter new phone number.          *");
                    System.out.println("* 6. Enter new email.                 *");
                    System.out.println("* 7. Enter new level.                 *");
                    System.out.println("* 8. Enter new position.              *");
                    System.out.println("* 9. Enter new salary.                *");
                    System.out.println("* 10. Exit.                           *");
                    System.out.println(" ------------------------------------- ");
                    choose = Integer.parseInt(scanner.nextLine());
                    switch (choose) {
                        case 1:
                            System.out.println("Enter new full name: ");
                            String editName = scanner.nextLine();
                            employee.setFullName(editName);
                            break;
                        case 2:
                            System.out.println("Enter new date of birth: ");
                            String editBirth = scanner.nextLine();
                            employee.setDataOfBirth(editBirth);
                            break;
                        case 3:
                            System.out.println("Enter new gender: ");
                            String editGender = scanner.nextLine();
                            employee.setGender(editGender);
                            break;
                        case 4:
                            System.out.println("Enter new identity card number: ");
                            String editCMND = scanner.nextLine();
                            employee.setIdentityCardNumber(editCMND);
                            break;
                        case 5:
                            System.out.println("Enter new phone number: ");
                            String editPhone = scanner.nextLine();
                            employee.setPhoneNumber(editPhone);
                            break;
                        case 6:
                            System.out.println("Enter new email: ");
                            String editEmail = scanner.nextLine();
                            employee.setEmail(editEmail);
                            break;
                        case 7:
                            System.out.println("Enter new level: ");
                            String editLevel = scanner.nextLine();
                            employee.setLevel(editLevel);
                            break;
                        case 8:
                            System.out.println("Enter new position: ");
                            String editPosition = scanner.nextLine();
                            employee.setPosition(editPosition);
                            break;
                        case 9:
                            System.out.println("Enter new salary: ");
                            int editSalary = Integer.parseInt(scanner.nextLine());
                            employee.setSalary(editSalary);
                            break;
                        case 10:
                            break;
                    }
                } while (choose != 10);
            }
        }
    }
}
