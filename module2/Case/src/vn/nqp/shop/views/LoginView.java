package vn.nqp.shop.views;

import java.util.Scanner;

public class LoginView {
    public static final Scanner scanner = new Scanner(System.in);

    public static void launch() {
        menuOption();
    }

    public static void exit() {
        System.out.println(" END PROGRAM | HẸN GẶP LẠI \uD83C\uDF8A ");
        System.exit(0);
    }

    public static void menuOption() {
        do {
            mainMenu();
            try {
                System.out.println("\nChọn chức năng ");
                System.out.print(" => ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        MainLauncherAD.launch();
                        break;
                    case 2:
                        OrderMenuView.launch();
                        break;
                    case 3:
                        CreateAccount.launch();
                        break;
                    case 4:
                        exit();
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
        System.out.println("*          1. Đăng nhập quản lí             *");
        System.out.println("*          2. Đăng nhập người dùng          *");
        System.out.println("*          3. Tạo người dùng                *");
        System.out.println("*          4. Thoát khỏi chương trình       *");
        System.out.println("*                                           *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * *");
    }
}
