package menu.user;

import java.util.Scanner;

public class UserManage {
    public static void showMenuUser() {
        System.out.println("*************************************************");
        System.out.println("*                                               *");
        System.out.println("*            1. View product list                    *");
        System.out.println("*            2. Mua san pham            *");
        System.out.println("*            3. Hien danh sach nguoi dung       *");
        System.out.println("*            4. Quay lai                        *");
        System.out.println("*                                               *");
        System.out.println("*************************************************");
        Scanner scanner = new Scanner(System.in);
        boolean cont = true;
        do {
            System.out.print("=>");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    cont = true;
                    break;
                default:
                    System.out.println("Vui long nhap lai!!!");
            }
        } while (cont);
    }
}
