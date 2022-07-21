package CaseStudy.models;

public class Contract {
    private int contractNumber;
    private int bookingId;
    private double deposit;
    private double payment;
    private String customerId;

    public Contract() {
    }

    public Contract(int contractNumber, int bookingId, double deposit, double payment, String customerId) {
        this.contractNumber = contractNumber;
        this.bookingId = bookingId;
        this.deposit = deposit;
        this.payment = payment;
        this.customerId = customerId;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractNumber=" + contractNumber +
                ", bookingId=" + bookingId +
                ", deposit=" + deposit +
                ", payment=" + payment +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
