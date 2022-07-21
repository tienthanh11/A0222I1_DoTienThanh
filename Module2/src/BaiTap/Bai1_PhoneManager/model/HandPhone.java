package BaiTap.Bai1_PhoneManager.model;

public class HandPhone extends Phone {
    private String country;
    private String status;

    public HandPhone() {
    }

    public HandPhone(int id, String name, double price, String manufacturer, String country, String status) {
        super(id, name, price, manufacturer);
        this.country = country;
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HandPhone{" +
                super.toString() +
                "country='" + country + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String toData() {
        return String.format("%s,%s,%s,1", super.toData(), country, status);
    }
}
