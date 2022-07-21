package CaseStudy.models;

public class House extends Facility {
    private String roomStandard;
    private int floorNumber;

    public House() {
    }

    public House(String roomStandard, int floorNumber) {
        this.roomStandard = roomStandard;
        this.floorNumber = floorNumber;
    }

    public House(String serviceName, double areaUsed, double roomRate, int personNumber, String rentType, String roomStandard, int floorNumber) {
        super(serviceName, areaUsed, roomRate, personNumber, rentType);
        this.roomStandard = roomStandard;
        this.floorNumber = floorNumber;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return "House{" +
                super.toString() +
                "roomStandard='" + roomStandard + '\'' +
                ", floorNumber=" + floorNumber +
                '}';
    }
}
