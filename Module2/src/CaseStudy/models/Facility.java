package CaseStudy.models;

public abstract class Facility {
    private String serviceName;
    private double areaUsed;
    private double roomRate;
    private int personNumber;
    private String rentType;      //Thuê theo năm, tháng, ngày, giờ

    public Facility() {
    }

    public Facility(String serviceName, double areaUsed, double roomRate, int personNumber, String rentType) {
        this.serviceName = serviceName;
        this.areaUsed = areaUsed;
        this.roomRate = roomRate;
        this.personNumber = personNumber;
        this.rentType = rentType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getAreaUsed() {
        return areaUsed;
    }

    public void setAreaUsed(double areaUsed) {
        this.areaUsed = areaUsed;
    }

    public double getRoomRate() {
        return roomRate;
    }

    public void setRoomRate(double roomRate) {
        this.roomRate = roomRate;
    }

    public int getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(int personNumber) {
        this.personNumber = personNumber;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "serviceName='" + serviceName + '\'' +
                ", areaUsed=" + areaUsed +
                ", roomRate=" + roomRate +
                ", personNumber=" + personNumber +
                ", rentType='" + rentType + '\'' +
                '}';
    }
}
