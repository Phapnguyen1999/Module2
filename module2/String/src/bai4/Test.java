package bai4;

public class Test {
    public static String[] arrClass = {"C11I21", "C0318G", "C12", "M03128G", "a12341P0", "P123123G", "P4G"};
    public static String[] arrClass2 =
            {"C12345", "C123OP", "P5463G"};

    public static void main(String[] args) {
        ValidateClass check = new ValidateClass();
        for (String strig : arrClass) {
            if (check.isClass(strig)) {
                System.out.println(strig + " is class");
            } else
                System.out.println(strig + " is not class ");
        }

        for (String string : arrClass2) {
            if (check.isClass(string)) {
                System.out.println(string + " is class");
            } else
                System.out.println(string + " is not class");
        }
    }
}
