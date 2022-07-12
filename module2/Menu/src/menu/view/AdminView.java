package menu.admin;

import menu.product.ProductView;

import java.util.Scanner;

public class AdminView {
    private ProductView productView=new ProductView();
    public void adminMenu() {

        Scanner scanner = new Scanner(System.in);
        boolean cont = true;
        do {
            System.out.println("******************* Admin Menu *******************");
            System.out.println("*                                               *");
            System.out.println("*            1. User Manage                     *");
            System.out.println("*            2. Product Manage                  *");
            System.out.println("*            3. Order Manage                    *");
            System.out.println("*            0. Quay lai                        *");
            System.out.println("*                                               *");
            System.out.println("*************************************************");
            System.out.print("=>");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
//                    UserList();
                    break;
                case "2":
                    productView.showMenu();
                    break;
                case "3":
//                    OrderManage();
                    break;
                case "0":
                    cont = false;
                    break;
                default:
                    System.out.println("Please choice again!!!");
            }
        } while (cont);
    }
}



