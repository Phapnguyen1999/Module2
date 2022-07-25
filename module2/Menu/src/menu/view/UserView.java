package menu.view;

import menu.model.User;
import menu.service.UserService;
import menu.utils.AppUtils;

import java.util.Scanner;

public class UserView {
    private UserService userService;
    private final Scanner scanner=new Scanner(System.in);
    public UserView(){
        userService=UserService.getInstance();
    }
    public void addUser(){
        do {
            try {
                long id = System.currentTimeMillis() / 1000;
                String username = inputUsername();
                String password = inputPassword();
                String fullName = inputFullName(InputOption.ADD);
                String phone = inputPhone(InputOption.ADD);
                String address = inputAddress(InputOption.ADD);
                String email = inputEmail();
                User user = new User(id, username, password, fullName, phone, email, address);
                userService.add(user);
                System.out.println("Đã thêm thành công!\uD83C\uDF8A");
            } catch (Exception e) {
                System.out.println("Nhập sai. vui lòng nhập lại!");
            }
        } while (AppUtils.isRetry(InputOption.ADD));
    }
    public void editUser(){

    }
    public void deleteUser(){

    }
    public void showUser(){

    }
    public void inputUserName(){
        boolean cont=true;
        do {
            System.out.print("Nhập Username: ");
            String name=scanner.nextLine();
            if (userService.existsByUsername(name)){
                System.out.println("Username này đã tồn tại. Vui lòng nhập lại");
            }
        }while (cont);


    }
}
