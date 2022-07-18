package vn.nqp.shop.views;

import java.util.Scanner;

public class OrderMenuView {

    public static void launch() {
        UserView userView = new UserView();
        userView.userLogin();
        Scanner scanner = new Scanner(System.in);
        OrderView orderView = new OrderView();
        int choice;
        boolean cont = true;
        do {
            menuOrder();
            try {
                System.out.println("Chọn chức năng");
                System.out.print(" => ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        orderView.showProduct();
                        break;
                    case 2:
                        orderView.addOrder();
                        break;
                    case 3:
                        orderView.showOrderbyUser();
                        break;
                    case 4:
                        orderView.deleteOrder();
                        break;
                    case 5:
                        cont = false;
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Nhập sai! vui lòng nhập lại");
            }
        } while (cont);
    }

    public static void launchAd() {
        Scanner scanner = new Scanner(System.in);
        OrderView orderView = new OrderView();
        int choice;
        boolean cont = true;
        do {
            menuOrderAd();
            try {
                System.out.println("Chọn chức năng");
                System.out.print(" => ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        orderView.showAllOrder();
                        break;
                    case 2:
                        orderView.confirmOrder();
                        break;
                    case 3:
                        orderView.showListConfirm();
                        break;
                    case 4:
                        orderView.deleteOrderByAd();
                        break;
                    case 5:
                        cont = false;
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Nhập sai! vui lòng nhập lại");
            }
        } while (cont);
    }

    public static void menuOrderAd() {
        System.out.println("* * * * * * * * * ORDER MANAGER * * * * * * * * * * *");
        System.out.println("*                                                   *");
        System.out.println("*            1. Hiển thị danh sách đơn hàng         *");
        System.out.println("*            2. Xác nhận xác đơn hàng (ID)          *");
        System.out.println("*            3. Hiển thị đơn hàng đã xác nhận       *");
        System.out.println("*            4. Xoá Đơn hàng (ID)                   *");
        System.out.println("*            5. Quay lại                           *");
        System.out.println("*                                                   *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * *");
    }

    public static void menuOrder() {
        System.out.println("* * * * * * * * * * * MENU USER * * * * * * * * * * *");
        System.out.println("*                                                    *");
        System.out.println("*            1. Hiển thị danh sách sản phẩm          *");
        System.out.println("*            2. Order sản phẩm bằng ID               *");
        System.out.println("*            3. Hiển thị danh sách order             *");
        System.out.println("*            4. Xoá sản phẩm đã order                *");
        System.out.println("*            5. Đăng xuất                             *");
        System.out.println("*                                                    *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * **");
    }
}
