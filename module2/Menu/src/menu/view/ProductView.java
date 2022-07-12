package menu.product;

import java.util.Scanner;

public class ProductView {
    public ProductService productService;
    private static final Scanner scanner = new Scanner(System.in);

    public ProductView() {
        productService = new ProductService();
    }

    public void showMenu() {
        boolean cont = true;
        do {
            System.out.println("*************************************************");
            System.out.println("*                                               *");
            System.out.println("*            1. Them san pham                   *");
            System.out.println("*            2. Sua thong tin san pham          *");
            System.out.println("*            3. Xoa san pham                    *");
            System.out.println("*            4. Hien thi san pham               *");
            System.out.println("*            5. Tim kiem san pham               *");
            System.out.println("*            6. Sap xep san pham                *");
            System.out.println("*            7. hien thi da ban                 *");
            System.out.println("*            0. Quay lai                        *");
            System.out.println("*                                               *");
            System.out.println("*************************************************");
            System.out.print("Please choice => ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addProduct();
                    break;
                case "2":
                    editProduct();
                    break;
                case "3":
                    deleteProduct();
                    break;
                case "4":
                    showProducts();
                    break;
                case "5":
                    findProduct();
                    break;
                case "6":
                    showProductsASC();
                    break;
                case "7":
                    sold();
                    break;
                case "0":
                    cont = false;
                default:
                    System.out.println("Vui long nhap lai!!!");
            }
        } while (cont);
    }

    private void sold() {
        System.out.printf(
                "\n\t%-16s%-36s%-26s%s\n\n",
                "Product Id",
                "Product Name",
                "Product Quantity",
                "Product Price"
        );
        for (Product product : productService.soldProduct()) {
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


    public void showProducts() {
        System.out.printf(
                "\n\t%-16s%-36s%-26s%s\n\n",
                "Product Id",
                "Product Name",
                "Product Quantity",
                "Product Price"
        );
        for (Product product : productService.findAll()) {
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

    public void addProduct() {
        String productName;
        do {
            System.out.print("Name: ");
            productName = scanner.nextLine();
            if (productService.isNameInList(productName)) {
                System.out.println("Product had in the product list");
            }
        } while (productService.isNameInList(productName));


        System.out.print("Quantity: ");
        int productQuantity = Integer.parseInt(scanner.nextLine());

        System.out.print("Price: ");
        double productPrice = Double.parseDouble(scanner.nextLine());
        Product newProduct = new Product(
                productName,
                productQuantity,
                productPrice
        );
        productService.addProduct(newProduct);
        System.out.println("\n Product added successfully!");
    }

    public void editProduct() {

        System.out.print("Product id to edit: ");
        long id = Long.parseLong(scanner.nextLine());
        if (!productService.existsById(id)) {
            System.out.println("Product id does not exist");
            return;
        }

        System.out.print("Product name: ");
        String name = scanner.nextLine();

        System.out.print("Product quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.print("Product price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Product newProduct = new Product(
                id,
                name,
                quantity,
                price
        );
        productService.updateProduct(newProduct);

        System.out.println("\n Product edited successfully!");
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

    public void buyProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name product need buy : ");
        String name = scanner.nextLine();
        if (!productService.isNameInList(name)) {
            System.out.println("Product name does not exist");
            return;
        }
        System.out.print("Quantity : ");
        int quantity = Integer.parseInt(scanner.nextLine());
        productService.buyProductByName(name);
        for (Product product : productService.findAll()) {
            if (product.getName().equalsIgnoreCase(name)) {
                Product newProduct = new Product(
                        product.getId(),
                        name,
                        quantity,
                        product.getPrice()
                );
                productService.addProductSold(newProduct);

                System.out.println("\n Product sold successfully!");
            }
        }
    }

}
