package bai5;

public class Test {
    private static String[] arrNumber = {"(84)-(0978489648)",
            "(a8)-(22222222)", "(814)-(0978489648)"};
    private static String[] arrNumber2 =
            {"(12)-(12345678910)", "((13)-(123456789101112)"};
    public static void main(String[] args) {
        ValidatePhone sdt = new ValidatePhone();
        for (String number : arrNumber) {
            if (sdt.isRegularExpresssionSDT(number)) {
                System.out.println(number + " is number phone");
            } else
                System.out.println(number + " is not number ");
        }

        for (String number : arrNumber2) {
            if (sdt.isRegularExpresssionSDT(number)) {
                System.out.println(number + " is number phone");
            } else
                System.out.println(number + " is not number phone");
        }
    }
}
