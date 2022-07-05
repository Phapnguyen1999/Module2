package menu;

import java.util.Scanner;

public class User {
    public static void login() {
        Scanner scanner = new Scanner(System.in);
        boolean cont = false;
        do {
            String user = scanner.nextLine();
            String ps = scanner.nextLine();
            if (user.equals("phap") && ps.equals("phap")) {
                MainMenu.mainMenu();
            }

        } while (cont);
    }
}
