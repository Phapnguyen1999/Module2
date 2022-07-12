package vn.nqp.shop.views;

import java.util.Scanner;

public class UserMenuViewByAd {
    public static void launch() {
        Scanner scanner = new Scanner(System.in);
        UserViewByAd userViewByAd = new UserViewByAd();
        int choice;
        boolean cont = true;
        do {
            menuUser();
            try {
                System.out.println("Chọn chức năng");
                System.out.print(" => ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        userViewByAd.addUser();
                        break;
                    case 2:
                        userViewByAd.updateUser();
                        break;
                    case 3:
                        userViewByAd.showUsers(InputOption.SHOW);
                        break;
                    case 4:
                        userViewByAd.deleteUser();
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

    public static void menuUser() {
        System.out.println("* * * * * * * * * * USERS MANAGER * * * * * * * * * *");
        System.out.println("*                                                   *");
        System.out.println("*              1. Thêm người dùng                   *");
        System.out.println("*              2. Sửa thông tin người dùng          *");
        System.out.println("*              3. Hiện danh sách người dùng         *");
        System.out.println("*              4. Xoá người dùng                    *");
        System.out.println("*              5. Quay lại                          *");
        System.out.println("*                                                   * ");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * *");
    }
}
