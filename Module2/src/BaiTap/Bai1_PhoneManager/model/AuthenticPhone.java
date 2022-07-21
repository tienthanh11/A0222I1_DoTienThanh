package BaiTap.Bai1_PhoneManager.model;

public class AuthenticPhone extends Phone {
    private int granteeByYear;
    private String granteeByCode;

    public AuthenticPhone() {
    }

    public AuthenticPhone(int id, String name, double price, String manufacturer, int granteeByYear, String granteeByCode) {
        super(id, name, price, manufacturer);
        this.granteeByYear = granteeByYear;
        this.granteeByCode = granteeByCode;
    }

    public int getGranteeByYear() {
        return granteeByYear;
    }

    public void setGranteeByYear(int granteeByYear) {
        this.granteeByYear = granteeByYear;
    }

    public String getGranteeByCode() {
        return granteeByCode;
    }

    public void setGranteeByCode(String granteeByCode) {
        this.granteeByCode = granteeByCode;
    }

    @Override
    public String toString() {
        return "AuthenticPhone{" +
                super.toString() +
                "granteeByYear=" + granteeByYear +
                ", granteeByCode='" + granteeByCode + '\'' +
                '}';
    }

    public String toData(){
        return String.format("%s,%s,%s,0", super.toData(), granteeByYear, granteeByCode);
    }
}
