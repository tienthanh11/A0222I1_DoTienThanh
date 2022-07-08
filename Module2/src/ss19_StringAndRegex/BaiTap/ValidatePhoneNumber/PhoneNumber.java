package ss19_StringAndRegex.BaiTap.ValidatePhoneNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    private static Pattern pattern;
    private Matcher matcher;

    private static final String PHONE_NUMBER_REGEX = "^[(][0-9][1-9][)][-][(][0][0-9]{9}[)]$";

    public PhoneNumber() {
        pattern = Pattern.compile(PHONE_NUMBER_REGEX);
    }

    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
