package CaseStudy.models;

public class Villa extends Facility {
    private String roomStandard;
    private double swimmingPoolArea;
    private int floorNumber;

    public Villa() {
    }

    public Villa(String roomStandard, double swimmingPoolArea, int floorNumber) {
        this.roomStandard = roomStandard;
        this.swimmingPoolArea = swimmingPoolArea;
        this.floorNumber = floorNumber;
    }

    public Villa(String serviceName, double areaUsed, double roomRate, int personNumber, String rentType, String roomStandard, double swimmingPoolArea, int floorNumber) {
        super(serviceName, areaUsed, roomRate, personNumber, rentType);
        this.roomStandard = roomStandard;
        this.swimmingPoolArea = swimmingPoolArea;
        this.floorNumber = floorNumber;
    }


    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(double swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return "Villa{" +
                super.toString() +
                "roomStandard='" + roomStandard + '\'' +
                ", swimmingPoolArea=" + swimmingPoolArea +
                ", floorNumber=" + floorNumber +
                '}';
    }
}
