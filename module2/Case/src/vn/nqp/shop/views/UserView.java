package vn.nqp.shop.views;

import vn.nqp.shop.services.UserService;

import java.util.Scanner;

public class UserView {
    private final Scanner scanner = new Scanner(System.in);
    protected final UserService userService;

    public UserView() {
        userService = UserService.getInstance();
    }

    public void showProduct() {

    }

    public void userLogin() {
        boolean isRetry = true;
        System.out.println("* * * * * * * * ĐĂNG NHẬP USER * * * * * * * *");
        do {
            System.out.print("Tên đăng nhập: ");
            String username = scanner.nextLine();
            System.out.print("Mật khẩu: ");
            String password = scanner.nextLine();
            if (userService.checkAccount(username, password)) {
                System.out.println("Bạn đã đăng nhập thành công \uD83C\uDF8A \n");
                System.out.println("CHÀO MỪNG BẠN ĐẾN VỚI AN NHIÊN TEA\n");
                isRetry = false;
                return;
            }
            if (!userService.checkAccount(username, password)) {
                System.out.println("Tài khoản không hợp lệ!");
                isRetry = isRetry();
            }
        } while (isRetry);
    }

    private boolean isRetry() {
        boolean cont = true;
        do {
            try {
                System.out.println("* * * * * * * * * CHỌN * * * * * * * * * * *");
                System.out.println("*                                          *");
                System.out.println("*      1.Nhấn 'y' để đăng nhập lại         *");
                System.out.println("*      2.Nhấn 'n' để thoát chương trình    *");
                System.out.println("*                                          *");
                System.out.println("* * * * * * * * * * * * * * * * * * * * * * ");
                System.out.print(" => ");
                String option = scanner.nextLine();
                switch (option) {
                    case "y":
                        return true;
                    case "n":
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
        return true;
    }
}
