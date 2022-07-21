package CaseStudy.models;

public class Customer extends Person {
    private String customerType;        //Diamond, Platinium, Gold, Silver, Member
    private String customerAddress;

    public Customer() {
    }

    public Customer(String customerType, String customerAddress) {
        this.customerType = customerType;
        this.customerAddress = customerAddress;
    }

    public Customer(int id, String fullName, String dataOfBirth, String gender, String identityCardNumber, String phoneNumber, String email, String customerType, String customerAddress) {
        super(id, fullName, dataOfBirth, gender, identityCardNumber, phoneNumber, email);
        this.customerType = customerType;
        this.customerAddress = customerAddress;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                super.toString() +
                "customerType='" + customerType + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }
}
