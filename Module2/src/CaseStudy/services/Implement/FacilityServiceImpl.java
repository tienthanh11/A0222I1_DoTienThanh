package CaseStudy.services.Implement;

import CaseStudy.models.Facility;
import CaseStudy.models.House;
import CaseStudy.models.Room;
import CaseStudy.models.Villa;
import CaseStudy.services.FacilityService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    private static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void displayFacility() {
        for(Map.Entry<Facility, Integer> element : facilityIntegerMap.entrySet()) {
            System.out.println("Service " + element.getKey() + " number of time rented: " + element.getValue());
        }
    }

    @Override
    public void displayMaintenance() {

    }

    @Override
    public void addNewVilla() {
        System.out.println("Enter service name: ");
        String serviceName = scanner.nextLine();
        System.out.println("Enter area used: ");
        double areaUsed = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter room rate: ");
        double roomRate = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter person number: ");
        int personNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter rent type: ");
        String rentType = scanner.nextLine();
        System.out.println("Enter room standard: ");
        String roomStandard = scanner.nextLine();
        System.out.println("Enter swimming pool area: ");
        double swimmingPoolArea = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter floor number: ");
        int floorNumber = Integer.parseInt(scanner.nextLine());

        Villa villa = new Villa(serviceName, areaUsed, roomRate, personNumber, rentType, roomStandard, swimmingPoolArea, floorNumber);
        facilityIntegerMap.put(villa, 0);
        System.out.println("Successfully added new villa");
    }

    @Override
    public void addNewHouse() {
        System.out.println("Enter service name: ");
        String serviceName = scanner.nextLine();
        System.out.println("Enter area used: ");
        double areaUsed = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter room rate: ");
        double roomRate = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter person number: ");
        int personNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter rent type: ");
        String rentType = scanner.nextLine();
        System.out.println("Enter room standard: ");
        String roomStandard = scanner.nextLine();
        System.out.println("Enter floor number: ");
        int floorNumber = Integer.parseInt(scanner.nextLine());

        House house = new House(serviceName, areaUsed, roomRate, personNumber, rentType, roomStandard, floorNumber);
        facilityIntegerMap.put(house, 0);
        System.out.println("Successfully added new house");
    }

    @Override
    public void addNewRoom() {
        System.out.println("Enter service name: ");
        String serviceName = scanner.nextLine();
        System.out.println("Enter area used: ");
        double areaUsed = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter room rate: ");
        double roomRate = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter person number: ");
        int personNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter rent type: ");
        String rentType = scanner.nextLine();
        System.out.println("Enter free service: ");
        String freeService = scanner.nextLine();

        Room room = new Room(serviceName, areaUsed, roomRate, personNumber, rentType, freeService);
        facilityIntegerMap.put(room, 0);
        System.out.println("Successfully added new room");
    }
}
