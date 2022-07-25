package menu.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductMenuView {
    public static void launch() {

        int option = -1;
        do {
            Scanner scanner = new Scanner(System.in);
            ProductView productView = new ProductView();
            menuProductManage();
            try {
                System.out.println("Chọn chức năng");
                System.out.print(" => ");
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        productView.addProduct();
                        break;
                    case 2:
                        productView.editProduct();
                        break;
                    case 3:
                        productView.deleteProduct();
                        break;
                    case 4:
                        productView.showProducts();
                        break;
                    case 5:
                        productView.findProduct();
                        break;
                    case 6:
                        productView.showProductsASC();
                        break;
                    case 7:
                        option = 7;
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Nhập sai. Vui lòng nhập lại");
            }
        } while (option != 7);
    }

    public static void menuProductManage() {
        System.out.println("*************************************************");
        System.out.println("*                                               *");
        System.out.println("*            1. Them san pham                   *");
        System.out.println("*            2. Sua thong tin san pham          *");
        System.out.println("*            3. Xoa san pham                    *");
        System.out.println("*            4. Hien thi san pham               *");
        System.out.println("*            5. Tim kiem san pham               *");
        System.out.println("*            6. Sap xep san pham                *");
        System.out.println("*            7. Quay lai                        *");
        System.out.println("*                                               *");
        System.out.println("*************************************************");
    }
}
