package menu.admin;

import menu.product.ProductView;
import menu.user.UserManage;

import java.util.Scanner;

public class MainMenuAdmin {
    public static void adminMenu() {

        Scanner scanner = new Scanner(System.in);
        boolean cont = true;
        do {
            System.out.println("******************* Admin Menu *******************");
            System.out.println("*                                               *");
            System.out.println("*            1. Quan li nguoi dung              *");
            System.out.println("*            2. Quan li san pham                *");
            System.out.println("*            3. Quan li don dat hang            *");
            System.out.println("*            4. Quay lai                        *");
            System.out.println("*                                               *");
            System.out.println("*************************************************");
            System.out.print("=>");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    UserManage.userManage();
                    break;
                case 2:
                    ProductView.showMenu();
                    break;
                case 3:
                    OrderManage.orderManager();
                    break;
                case 4:
                    cont = false;
                    break;
                default:
                    System.out.println("Vui long nhap lai!!!");
            }
        } while (cont);
    }
}



