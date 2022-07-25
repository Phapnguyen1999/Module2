package menu.view;

import menu.model.Product;
import menu.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    public ProductService productService;
    private static final Scanner scanner = new Scanner(System.in);

    public ProductView() {
        productService = ProductService.getInstance();
    }
    public void addProduct() {
        String productName;
        do {
            System.out.print("Tên sản phẩm: ");
            productName = scanner.nextLine();
            if (productService.isNameInList(productName)) {
                System.out.println("Sản phẩm đã có trong cửa hàng: ");
            }
        } while (productService.isNameInList(productName));

        System.out.print("Số lượng sản phẩm: ");
        int productQuantity = Integer.parseInt(scanner.nextLine());

        System.out.print("Giá sản phẩm: ");
        double productPrice = Double.parseDouble(scanner.nextLine());
        Product newProduct = new Product(
                productName,
                productQuantity,
                productPrice
        );
        productService.addProduct(newProduct);
        System.out.println("\n Sản phẩm đã được thêm thành công!");
    }

    public void editProduct() {
        System.out.print("Nhập Id SP muốn chỉnh sửa: ");
        long id = Long.parseLong(scanner.nextLine());
        if (!productService.existsById(id)) {
            System.out.println("Product id does not exist");
            return;
        }

        System.out.print("Tên sản phẩm: ");
        String name = scanner.nextLine();

        System.out.print("Số lượng sản phẩm: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.print("Giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());

        Product newProduct = new Product(
                id,
                name,
                quantity,
                price
        );
        productService.updateProduct(newProduct);

        System.out.println("\n Sản phẩm được chỉnh sửa thành công!");
    }

    public void showProducts() {
        System.out.printf(
                "\n\t%-16s%-36s%-26s%s\n\n",
                "Product Id",
                "Product Name",
                "Product Quantity",
                "Product Price"
        );
        List<Product> products = productService.findAll();
        for (Product product : products) {
            System.out.printf(
                    "\t%-16s %-36s %-26s%.2fđ\n",
                    product.getId(),
                    product.getName(),
                    product.getQuantity(),
                    product.getPrice()
            );
        }
        System.out.println();
    }

    public void showProductsASC() {
        System.out.printf(
                "\n\t%-16s%-36s%-26s%s\n\n",

                "Product Id",
                "Product Name",
                "Product Quantity",
                "Product Price"
        );
        for (Product product : productService.sortByASC()) {
            System.out.printf(
                    "\t%-16s %-36s %-26s%.2fđ\n",

                    product.getId(),
                    product.getName(),
                    product.getQuantity(),
                    product.getPrice()
            );
        }
        System.out.println();
    }


    public void deleteProduct() {
        System.out.print("Product id to delete: ");
        long id = Long.parseLong(scanner.nextLine());
        if (!productService.existsById(id)) {
            System.out.println("Product id does not exist");
            return;
        }
        productService.deleteById(id);
        System.out.println("\n Product deleted successfully!");
    }

    public void findProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name product need find : ");
        String name = scanner.nextLine();
        if (!productService.isNameInList(name)) {
            System.out.println("Product name does not exist");
            return;
        }
        productService.findProductByName(name);
    }
}
