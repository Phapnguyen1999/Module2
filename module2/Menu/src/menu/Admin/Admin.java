package menu;

import java.util.Scanner;

public class Admin {
    public static void login() {
        Scanner scanner = new Scanner(System.in);
        boolean cont = false;
        do {
            String user = scanner.nextLine();
            String ps = scanner.nextLine();
            if (user.equals("admin") && ps.equals("admin")) {
                MainMenu.mainMenu();
            }

        } while (cont);
    }

}
