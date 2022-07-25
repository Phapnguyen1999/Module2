package bai5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhone {
    private static final String NUMBER_REGEX =
            "^\\(\\d{2}\\)-\\([0-9]{10,}\\)$";
    public boolean isRegularExpresssionSDT(String regex) {
        Pattern pattern = Pattern.compile(NUMBER_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
