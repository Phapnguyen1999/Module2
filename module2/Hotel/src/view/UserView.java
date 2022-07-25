package view;

import java.util.Scanner;

public class UserView {
    private final Scanner scanner = new Scanner(System.in);
    public void addUser() {
        do {
            try {
                  Integer id = inputId(InputOption.ADD);
                   long id = System.currentTimeMillis() / 1000;
                String username = inputUsername();
                String password = inputPassword();
                String fullName = inputFullName(InputOption.ADD);
                String phone = inputPhone(InputOption.ADD);
                String address = inputAddress(InputOption.ADD);
                String email = inputEmail();
                User newUser = new User(username, password, fullName, phone, email, address, Role.USER);
                setRole(newUser);
                userService.add(newUser);
                System.out.println("Đã thêm thành công!\uD83C\uDF8A");
            } catch (Exception e) {
                System.out.println("Nhập sai. vui lòng nhập lại!");
            }
        } while (AppUtils.isRetry(InputOption.ADD));
    }

}
