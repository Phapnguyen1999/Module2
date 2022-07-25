package menu.view;

import menu.utils.AppUtils;

import java.util.Scanner;

public class AdminView {
    private final Scanner scanner = new Scanner(System.in);

    public AdminView() {

    }

    public void adminLogin() {
        boolean isRetry;
        System.out.println("* * * * * * * * ĐĂNG NHẬP HỆ THỐNG * * * * * * * *");
        do {
            System.out.println("Username");
            String username = scanner.nextLine();
            System.out.println("Mật khẩu");
            String password = scanner.nextLine();
            if (username == null || password == null) {
                System.out.println("Tài khoản không hợp lệ ");
                isRetry = isRetry();
            } else {
                System.out.println("Bạn đã đăng nhập thành công \uD83C\uDF8A \n");
                System.out.println("CHÀO MỪNG BẠN ĐÃ ĐẾN VỚI CỬA HÀNG FAP PHONE\n");
                isRetry = false;
            }
        } while (isRetry);
    }

    private boolean isRetry() {
        do {
            try {
                System.out.println("✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ CHỌN ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿");
                System.out.println("✿                                      ✿");
                System.out.println("✿   1.Nhấn 'y' để đăng nhập lại        ✿");
                System.out.println("✿   2.Nhấn 'n' để thoát chương trình   ✿");
                System.out.println("✿                                      ✿");
                System.out.println("✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿");
                System.out.print(" ⭆ ");
                String option = scanner.nextLine();
                switch (option) {
                    case "y":
                        return true;
                    case "n":
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        break;
                }

            } catch (Exception ex) {
                System.out.println("Nhập sai! vui lòng nhập lại");
                ex.printStackTrace();
            }
        } while (true);
    }
}



