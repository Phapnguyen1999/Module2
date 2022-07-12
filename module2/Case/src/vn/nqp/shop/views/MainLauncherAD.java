package vn.nqp.shop.views;

import java.util.Scanner;

public class MainLauncherAD {
    private final static Scanner scanner = new Scanner(System.in);

    public static void launch() {
        AdminView adminView = new AdminView();
        adminView.adminLogin();
        menuOption();
    }

    public static void menuOption() {
        boolean cont = true;
        do {
            mainMenu();
            try {
                System.out.println("\nChọn chức năng ");
                System.out.print(" => ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        ProductMenuView.launch();
                        break;
                    case 2:
                        UserMenuViewByAd.launch();
                        break;
                    case 3:
                        OrderMenuView.launchAd();
                        break;
                    case 4:
                        cont = false;
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        menuOption();
                }
            } catch (Exception e) {
                System.out.println("Nhập sai! Vui lòng nhập lại");
            }
        } while (cont);
    }

    public static void mainMenu() {
        System.out.println("* * * * * * * * * MAIN MENU ADMIN * * * * * * * * *");
        System.out.println("*                                                 *");
        System.out.println("*             1. Quản lí sản phẩm                 *");
        System.out.println("*             2. Quản lí người dùng               *");
        System.out.println("*             3. Quản lí đơn đặt hàng             *");
        System.out.println("*             4. Đăng xuất                        *");
        System.out.println("*                                                 *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * *");
    }
}
