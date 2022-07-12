package vn.nqp.shop.views;

import vn.nqp.shop.model.User;
import vn.nqp.shop.services.UserServiceByAd;
import vn.nqp.shop.utils.AppUtils;
import vn.nqp.shop.utils.InstantUtils;
import vn.nqp.shop.utils.ValidateUtils;

import java.util.List;
import java.util.Scanner;

public class UserViewByAd {
    private UserServiceByAd userServiceByAd;
    private final Scanner scanner = new Scanner(System.in);

    public UserViewByAd() {
        userServiceByAd = UserServiceByAd.getInstance();
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

    public void showUsers(InputOption inputOption) {
        System.out.println("----------------------------------------- DANH SÁCH NGƯỜI DÙNG--------------------------------------- ");
        System.out.printf("%-15s %-22s %-15s %-22s %-15s %-20s %-20s %-20s %-20s\n",
                "Id",
                "Tên",
                "Số điện thoại",
                "Email",
                "Địa chỉ",
                "Người dùng",
                "Mật khẩu",
                "Ngày tạo",
                "Ngày cập nhật");
        List<User> users = userServiceByAd.findAll();
        for (User user : users) {
            System.out.printf("%-15d %-22s %-15s %-22s %-15s %-20s %-20s %-20s %-20s\n",
                    user.getId(),
                    user.getFullName(),
                    user.getMobile(),
                    user.getEmail(),
                    user.getAddress(),
                    user.getUsername(),
                    user.getPassword(),
                    InstantUtils.instantToString(user.getCreatedAt()),
                    user.getUpdatedAt() == null ? "" : InstantUtils.instantToString(user.getUpdatedAt())
            );
        }
        System.out.println("-----------------------------------------------------------------------------------------------------  ");
        if (inputOption == InputOption.SHOW) AppUtils.isRetry(InputOption.SHOW);
    }

    public void deleteUser() {
        do {
            try {
                long id = inputId(InputOption.DELETE);
                userServiceByAd.deleteById(id);
                System.out.println("Xoá thành công!");
            } catch (Exception e) {
                System.out.println("Nhập sai! vui lòng nhập lại");
            }
        } while (AppUtils.isRetry(InputOption.DELETE));
    }

    public void updateUser() {
        boolean isRetry = false;
        do {
            try {
                showUsers(InputOption.UPDATE);
                long id = inputId(InputOption.UPDATE);
                System.out.println("* * * * * * * * SỬA * * * * * * * *");
                System.out.println("*        1. Đổi tên               *");
                System.out.println("*        2. Sửa số điện thoại     *");
                System.out.println("*        3. Sửa địa chỉ           *");
                System.out.println("*        4. Quay lại              *");
                System.out.println("* * * * * * * * * * * * * * * * * *");

                int option = AppUtils.retryChoose(1, 4);
                User newUser = new User();
                newUser.setId(id);
                switch (option) {
                    case 1:
                        String name = inputFullName(InputOption.UPDATE);
                        newUser.setFullName(name);
                        userServiceByAd.updateUser(newUser);
                        System.out.println("Bạn đã đổi tên thành công!\uD83C\uDF89");
                        break;
                    case 2:
                        String phone = inputPhone(InputOption.UPDATE);
                        newUser.setMobile(phone);
                        userServiceByAd.updateUser(newUser);
                        System.out.println("Bạn đã đổi số điện thoại thành công\uD83C\uDF89");
                        break;
                    case 3:
                        String address = inputAddress(InputOption.UPDATE);
                        newUser.setAddress(address);
                        userServiceByAd.updateUser(newUser);
                        System.out.println("Bạn đã đổi thành công\uD83C\uDF89");
                        break;
                }
                isRetry = option != 4 && AppUtils.isRetry(InputOption.UPDATE);

            } catch (Exception e) {
                System.out.println("Nhập sai! vui lòng nhập lại");
            }
        } while (isRetry);
    }


    private long inputId(InputOption option) {
        long id;
        switch (option) {
            case ADD:
                System.out.println("Nhập Id: ");
                break;
            case UPDATE:
                System.out.println("Nhập id bạn muốn sửa: ");
                break;
            case DELETE:
                System.out.println("Nhập id người dùng muốn xoá: ");
        }
        boolean isRetry = false;
        do {
            System.out.print(" => ");
            id = Long.parseLong(scanner.nextLine());
            boolean exist = userServiceByAd.existById(id);
            switch (option) {
                case ADD:
                    if (exist)
                        System.out.println("Id này đã tồn tại. Vui lòng nhập id khác!");
                    isRetry = exist;
                    break;
                case UPDATE:
                    if (!exist)
                        System.out.println("Không tìm thấy id! Vui lòng nhập lại");
                    isRetry = !exist;
                    break;
                case DELETE:
                    if (!exist)
                        System.out.println("Không tìm thấy id! Vui lòng nhập lại");
                    isRetry = !exist;
                    break;

            }
        } while (isRetry);
        return id;
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
}
