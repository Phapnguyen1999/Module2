package testRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$");
        Matcher m = p.matcher("4647364519836445");
        boolean b = m.matches();
        System.out.println(b);
        Pattern p2 = Pattern.compile("^\\s*[a-zA-Z\\-]+\\s*[:]{1}\\s[a-zA-Z0-9\\s.#]+[;]{1}");
        Matcher m2 = p2.matcher("width : 29px;");
        System.out.println(m2.matches());

    }
}
