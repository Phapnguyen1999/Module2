package vn.nqp.shop.views;

import vn.nqp.shop.model.User;
import vn.nqp.shop.services.UserService;
import vn.nqp.shop.services.UserServiceByAd;
import vn.nqp.shop.utils.AppUtils;
import vn.nqp.shop.utils.ValidateUtils;

import java.util.Scanner;

public class CreateAccount {
    private final Scanner scanner = new Scanner(System.in);
    private final UserServiceByAd userServiceByAd;

    public CreateAccount() {
        userServiceByAd = new UserServiceByAd();
    }

    public static void launch() {
        CreateAccount createAccount = new CreateAccount();
        createAccount.addUser();
    }

    public void addUser() {
        do {
            try {
                long id = System.currentTimeMillis() / 1000;
                String username = inputUsername();
                String password = inputPassword();
                String fullName = inputFullName(InputOption.ADD);
                String phone = inputPhone(InputOption.ADD);
                String address = inputAddress(InputOption.ADD);
                String email = inputEmail();
                User newUser = new User(id, username, password, fullName, phone, email, address);
                userServiceByAd.addUser(newUser);
                System.out.println("Đã thêm thành công!\uD83C\uDF8A");
            } catch (Exception e) {
                System.out.println("Nhập sai. vui lòng nhập lại!");
            }
        } while (AppUtils.isRetry(InputOption.ADD));
    }

    public String inputUsername() {
        System.out.println("Nhập Username (không bao gồm dấu cách, kí tự đặc biệt)");
        System.out.print(" => ");
        String username;

        do {
            if (!ValidateUtils.isUsernameValid(username = AppUtils.retryString("Username"))) {
                System.out.println(username + " của bạn không đúng định dạng! Vui lòng kiểm tra và nhập lại ");
                System.out.print(" => ");
                continue;
            }
            if (userServiceByAd.existsByUsername(username)) {
                System.out.println("Username này đã tồn tại. Vui lòng nhập lại");
                System.out.print(" => ");
                continue;
            }
            break;
        } while (true);

        return username;
    }

    private String inputFullName(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập họ và tên (vd: Nguyen Phap) ");
                break;
            case UPDATE:
                System.out.println("Nhập tên mà bạn muốn sửa đổi");
                break;
        }

        System.out.print(" => ");
        String fullName;
        while (!ValidateUtils.isNameValid(fullName = scanner.nextLine())) {
            System.out.println("Tên " + fullName + "không đúng định dạng." + " Vui lòng nhập lại!" + " (Tên phải viết hoa chữ cái đầu và không dấu)");
            System.out.println("Nhập tên (vd: Nguyen Phap) ");
            System.out.print(" => ");
        }
        return fullName;
    }

    public String inputPhone(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập số điện thoại (vd: 0935272937): ");
                break;
            case UPDATE:
                System.out.println("Nhập số điện thoại mà bạn muốn đổi");
                break;
        }
        System.out.print(" => ");
        String phone;
        do {
            phone = scanner.nextLine();
            if (!ValidateUtils.isPhoneValid(phone)) {
                System.out.println("Số " + phone + " của bạn không đúng. Vui lòng nhập lại! " + "(Số điện thoại bao gồm 10 số và bắt đầu là số 0)");
                System.out.println("Nhập số điện thoại (vd: 0935272937)");
                System.out.print(" => ");
                continue;
            }
            if (userServiceByAd.existsByPhone(phone)) {
                System.out.println("Số này đã tồn tại! Mời bạn nhập lại");
                System.out.print(" => ");
                continue;
            }
            break;
        } while (true);

        return phone;
    }

    private String inputEmail() {
        System.out.println("Nhập email (vd: phap@gmail.com)");
        System.out.print(" => ");
        String email;
        do {
            if (!ValidateUtils.isEmailValid(email = scanner.nextLine())) {
                System.out.println("Email " + email + "của bạn không đúng định dạng! Vui lòng kiểm tra và nhập lại ");
                System.out.println("Nhập email (vd: phap@gmail.com)");
                System.out.print(" => ");
                continue;
            }
            if (userServiceByAd.existsByEmail(email)) {
                System.out.println("Email " + email + "của bạn đã tồn tại! vui lòng kiểm tra lại");
                System.out.println("Nhập email (vd: phap@gmail.com)");
                System.out.print(" => ");
                continue;
            }
            break;
        } while (true);
        return email;
    }

    private String inputPassword() {
        System.out.println("Nhập mật khẩu( mật khẩu phải > 8 kí tự )");
        System.out.print(" => ");
        String password;
        while (!ValidateUtils.isPasswordValid(password = scanner.nextLine())) {
            System.out.println("Mật khẩu yếu! Vui lòng nhập lại ");
            System.out.print(" => ");
        }
        return password;
    }

    private String inputAddress(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập địa chỉ (vd: Huế)");
                break;
            case UPDATE:
                System.out.println("Nhập địa chỉ mà bạn muốn đổi");
                break;
        }
        System.out.print(" => ");
        return scanner.nextLine();
    }
//        try {
//            long id = System.currentTimeMillis() / 1000;
//            String username=
//            System.out.println("Nhập Username (không bao gồm dấu cách, kí tự đặc biệt)");
//            System.out.print(" => ");
//            do {
//                username = scanner.nextLine();
//                if (!ValidateUtils.isUsernameValid(username)) {
//                    System.out.println(username + " của bạn không đúng định dạng! Vui lòng kiểm tra và nhập lại ");
//                    System.out.print(" => ");
//                    continue;
//                }
//                if (userServiceByAd.existsByUsername(username)) {
//                    System.out.println("Username này đã tồn tại. Vui lòng nhập lại");
//                    System.out.print(" => ");
//                    continue;
//                }
//                break;
//            } while (true);
//            System.out.println("Nhập mật khẩu( mật khẩu phải > 8 kí tự ): ");
//            System.out.print(" => ");
//            String password;
//            do {
//                password = scanner.nextLine();
//                if (!ValidateUtils.isPasswordValid(password)) {
//                    System.out.println("Mật khẩu yếu! Vui lòng nhập lại ");
//                    System.out.print(" => ");
//                }
//            } while (!ValidateUtils.isPasswordValid(password));
//            System.out.println("Nhập họ và tên (Tên phải viết hoa chữ cái đầu và không dấu vd: Nguyen Quoc Phap)");
//            System.out.print(" => ");
//            String fullName;
//            do {
//                fullName = scanner.nextLine();
//                if (!ValidateUtils.isNameValid(fullName)) {
//                    System.out.println("Tên " + fullName + "không đúng định dạng." + " Vui lòng nhập lại!");
//                    System.out.println(" => ");
//                }
//            } while (!ValidateUtils.isNameValid(fullName));
//            System.out.println("Nhập số điện thoại (vd: 0935483835)");
//            System.out.print(" => ");
//            String phone;
//            do {
//                phone = scanner.nextLine();
//                if (!ValidateUtils.isPhoneValid(phone)) {
//                    System.out.println("Số " + phone + " của bạn không đúng. Vui lòng nhập lại! " + "(Số điện thoại bao gồm 10 số và bắt đầu là số 0)");
//                    System.out.print(" => ");
//                    continue;
//                }
//                if (userServiceByAd.existsByPhone(phone)) {
//                    System.out.println("Số này đã tồn tại! Mời bạn nhập lại");
//                    System.out.print(" => ");
//                    continue;
//                }
//                break;
//            } while (true);
//            System.out.println("Nhập địa chỉ (vd Huế): ");
//            System.out.println(" => ");
//            String address = scanner.nextLine();
//            System.out.println("Nhập email: (vd: phap@gmail.com)");
//            System.out.print(" => ");
//            String email;
//            do {
//                email = scanner.nextLine();
//                if (!ValidateUtils.isEmailValid(email)) {
//                    System.out.println("Email " + email + "của bạn không đúng định dạng! Vui lòng kiểm tra và nhập lại ");
//                    System.out.print(" => ");
//                    continue;
//                }
//                if (userServiceByAd.existsByEmail(email)) {
//                    System.out.println("Email " + email + "của bạn đã tồn tại! vui lòng kiểm tra lại");
//                    System.out.print(" => ");
//                    continue;
//                }
//                break;
//            } while (true);
//            User user = new User(id, username, password, fullName, phone, email, address);
//            userServiceByAd.addUser(user);
//            System.out.println("Đã thêm thành công!\uD83C\uDF8A");
//        } catch (Exception e) {
//            System.out.println("Nhập sai. vui lòng nhập lại!");
//        }
}
