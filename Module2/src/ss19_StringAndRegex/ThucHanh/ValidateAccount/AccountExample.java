package ss19_StringAndRegex.ThucHanh.ValidateAccount;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountExample {
    	/*Không chứa các ký tự đặc biệt
	  Phải dài hơn 6 ký tự
	  Không chứa các ký tự viết hoa
	  Cho phép dấu gạch dưới (_)
	*/
    private static final String ACCOUNT_REGEX = "^[_a-z0-9]{6,}$";

    public AccountExample() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
