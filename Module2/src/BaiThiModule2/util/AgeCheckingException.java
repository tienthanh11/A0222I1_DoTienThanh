package BaiThiModule2.util;

public class AgeCheckingException extends Exception {
    public AgeCheckingException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Lỗi nhập vào tuổi: " + super.getMessage();
    }
}
