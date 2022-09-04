package model;

public class Room extends Service {
    private String free_service;

    public Room() {
    }

    public Room(String free_service) {
        this.free_service = free_service;
    }

    public Room(int service_id, String service_name, double service_area, double service_cost, int service_max_people,
                int rent_type_id, String free_service) {
        super(service_id, service_name, service_area, service_cost, service_max_people, rent_type_id);
        this.free_service = free_service;
    }

    public String getFree_service() {
        return free_service;
    }

    public void setFree_service(String free_service) {
        this.free_service = free_service;
    }
}
