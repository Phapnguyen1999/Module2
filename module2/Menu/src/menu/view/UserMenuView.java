package menu.view;

import java.util.Scanner;

public class UserMenuView {
    public static void lauch() {
        Scanner scanner = new Scanner(System.in);
        UserView userView = new UserView();
        int option = -1;
        do {
            menuUser();
            try {
                do {
                    System.out.println("Chọn chức năng");
                    System.out.print(" => ");
                    option = Integer.parseInt(scanner.nextLine());
                    if (option > 4 || option < 1) System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                } while (option > 4 || option < 1);
                switch (option) {
                    case 1:
                        userView.addUser();
                        break;
                    case 2:
                        userView.editUser();
                        break;
                    case 3:
                        userView.showUser();
                        break;
                    case 4:
                        userView.deleteUser();
                        break;
                    case 0:
                        option=4;
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Nhập sai! vui lòng nhập lại");
            }
        } while (option != 0);

    }

    public static void menuUser() {
        System.out.println("* * * * * * * * USERS MANAGER * * * * * * * *");
        System.out.println("*                                           *");
        System.out.println("*        1. Thêm người dùng                 *");
        System.out.println("*        2. Sửa thông tin người dùng        *");
        System.out.println("*        3. Hiện danh sách người dùng       *");
        System.out.println("*        4. Xoá người dùng                  *");
        System.out.println("*        0. Quay lại                        *");
        System.out.println("*                                           *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * *");
    }
}
