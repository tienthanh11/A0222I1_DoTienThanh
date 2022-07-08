package ss19_StringAndRegex.BaiTap.ValidatePhoneNumber;

public class PhoneNumberTest {
    private static PhoneNumber phoneNumber;
    public static final String[] validPhoneNumber = {"(84)-(0978489648)"};
    public static final String[] invalidPhoneNumber = {"(a8)-(22222222)"};

    public static void main(String args[]) {
        phoneNumber = new PhoneNumber();
        for (String phone : validPhoneNumber) {
            boolean isValid = phoneNumber.validate(phone);
            System.out.println("Phone number is " + phone + " is valid: " + isValid);
        }
        for (String phone : invalidPhoneNumber) {
            boolean isValid = phoneNumber.validate(phone);
            System.out.println("Phone number is " + phone + " is valid: " + isValid);
        }
    }
}
