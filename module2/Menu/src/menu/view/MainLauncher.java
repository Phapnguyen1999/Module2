package menu.view;

import java.util.Scanner;

public class MainLauncher {
    public static void launch() {
        AdminView adminView = new AdminView();
        adminView.adminLogin();
        menuOption();
    }

    public static void menuOption() {
        do {
            mainMenu();
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("\nChọn chức năng ");
                System.out.print(" => ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        ProductMenuView.launch();
                        break;
                    case "2":
                        UserMenuView.lauch();
                        break;
                    case "3":
                        System.out.println("Khong co");
                        //   OrderMenuView.lauch();
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        menuOption();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static void mainMenu() {
        System.out.println("* * * * * * * * * MAIN MENU * * * * * * * * *");
        System.out.println("*                                           *");
        System.out.println("*          1. Quản lí sản phẩm              *");
        System.out.println("*          2. Quản lí người dùng            *");
        System.out.println("*          3. Quản lí đơn đặt hàng          *");
        System.out.println("*                                           *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * *");
    }
}
