package CaseStudy.services.Implement;

import CaseStudy.models.*;
import CaseStudy.services.BookingService;
import CaseStudy.utils.BookingComparator;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    Scanner scanner = new Scanner(System.in);
    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());
    static List<Customer> customerList = new ArrayList<>();
    static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();

    static {
        customerList.add(new Customer(1, "Thanh", "01/01/2001","Male",
                "123123123", "0905145624", "thanh@gmail.com",
                "Vip", "Đà Nẵng"));
        customerList.add(new Customer(2, "Thảo", "17/10/2002","FeMale",
                "154263147", "0914364284", "thao@gmail.com",
                "Vip Pro", "Đà Nẵng"));

        facilityIntegerMap.put(new Villa("Villa",35,50,
                12,"Day","Vip",35,12),0);
        facilityIntegerMap.put(new House("House",30,30,
                30,"Day","Vip Pro",12),0);
        facilityIntegerMap.put(new Room("Room",30,
                45,20,"Day","Đồ ăn"),0);
    }

    @Override
    public void displayBooking() {

    }

    @Override
    public void addNewBooking() {
        int id = 1;
        if(!bookingSet.isEmpty()) {
            id = bookingSet.size();
        }

    }

    public static Customer chooseCustomer() {
        Customer customerNew = new Customer();
        System.out.println("List of customers: ");
        for(Customer customer : customerList) {
            System.out.println(customer.toString());
        }

        System.out.println("Enter customer id: ");
        boolean check = true;
        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.nextLine());
        while (check) {
            for(Customer customer: customerList) {
                if(id == customer.getId()) {
                    check = false;
                    customerNew = customer;
                }
            }
            if(check) {
                System.out.println("You entered wrong, please enter customer id: ");
                id = Integer.parseInt(scanner.nextLine());
            }

        }
        return customerNew;
    }

}
