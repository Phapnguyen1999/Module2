package vn.nqp.shop.views;

import vn.nqp.shop.model.Product;
import vn.nqp.shop.services.ProductService;
import vn.nqp.shop.utils.AppUtils;

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
        do {
            try {
                long idProduct = System.currentTimeMillis() / 1000;
                String productName = inputProductName(InputOption.ADD);
                String description = inputDescription(InputOption.ADD);
                double price = inputPrice(InputOption.ADD);
                Product newProduct = new Product(idProduct, productName, description, price);
                productService.addProduct(newProduct);
                System.out.println("\n Sản phẩm đã được thêm thành công!");
            } catch (Exception e) {
                System.out.println("Nhập sai. vui lòng nhập lại!");
            }
        } while (AppUtils.isRetry(InputOption.ADD));
    }

    public void deleteProduct() {
        do {
            try {
                long id = inputId(InputOption.DELETE);
                productService.deleteById(id);
                System.out.println("Đã xoá thành công!");
            } catch (Exception e) {
                System.out.println("Nhập sai. vui lòng nhập lại!");
            }
        } while (AppUtils.isRetry(InputOption.DELETE));
    }

    public void editProduct() {
        boolean isRetry = false;
        do {
            try {
                long id = inputId(InputOption.UPDATE);
                System.out.println("* * * * * * * * SỬA * * * * * * * *");
                System.out.println("*        1. Sửa tên sản phẩm      *");
                System.out.println("*        2. Sửa mô tả             *");
                System.out.println("*        3. Sửa giá               *");
                System.out.println("*        4. Quay lại              *");
                System.out.println("* * * * * * * * * * * * * * * * * *");

                int option = AppUtils.retryChoose(1, 4);
                Product newProduct = new Product();
                newProduct.setId(id);
                switch (option) {
                    case 1:
                        String productName = inputProductName(InputOption.UPDATE);
                        newProduct.setName(productName);
                        productService.updateProduct(newProduct);
                        System.out.println("Bạn đã đổi tên thành công!\uD83C\uDF89");
                        break;
                    case 2:
                        String description = inputDescription(InputOption.UPDATE);
                        newProduct.setDescription(description);

                        productService.updateProduct(newProduct);
                        System.out.println("Bạn đã đổi mô tả thành công\uD83C\uDF89");
                        break;
                    case 3:
                        double price = inputPrice(InputOption.UPDATE);
                        newProduct.setPrice(price);
                        productService.updateProduct(newProduct);
                        System.out.println("Bạn đã đổi giá bán thành công\uD83C\uDF89");
                        break;
                }
                isRetry = option != 4 && AppUtils.isRetry(InputOption.UPDATE);

            } catch (Exception e) {
                System.out.println("Nhập sai! vui lòng nhập lại");
            }
        } while (isRetry);
    }

    public void showProducts() {
        System.out.println("----------------------------------------- DANH SÁCH SẢN PHẨM --------------------------------------------- ");
        System.out.printf("\n\t%-16s %-16s %-45s %s\n\n", "Product Id", "Product Name", "Product Description", "Product Price");
        List<Product> products = productService.findAll();
        for (Product product : products) {
            System.out.printf("\t%-16s %-16s %-45s %s/100gram\n", product.getId(), product.getName(), product.getDescription(), AppUtils.doubleToVND(product.getPrice()));
        }
        System.out.println("--------------------------------------------------------------------------------------------------------- ");
    }

    public void showProductsASC() {
        List<Product> products = productService.sortByASC();
        System.out.println("----------------------------------------- SORT SẢN PHẨM THEO GIÁ TĂNG DẦN --------------------------------------- ");
        System.out.printf("\n\t%-16s %-16s %-45s %s\n\n", "Product Id", "Product Name", "Product Description", "Product Price");
        for (Product product : products) {
            System.out.printf("\t%-16s %-16s %-45s %s/100gram\n", product.getId(), product.getName(), product.getDescription(), AppUtils.doubleToVND(product.getPrice()));
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------- ");
    }


    public void findProduct() {
        List<Product> products = new ArrayList<>();
        String name = null;
        do {
            System.out.print("Tên sản phẩm muốn tìm kiếm: ");
            name = scanner.nextLine();
            if (!productService.existsByName(name)) {
                System.out.println("Tên sản phẩm không tồn tại!");
                continue;
            }
            break;
        } while (true);
        products = productService.findProductByName(name);
        System.out.println("----------------------------------------- SẢN PHẨM TÌM KIẾM --------------------------------------------------- ");
        System.out.printf("\n\t%-16s %-16s %-45s %s\n\n", "Product Id", "Product Name", "Product Description", "Product Price");
        for (Product product : products) {
            System.out.printf("\t%-16s %-16s %-45s %s/100gram\n", product.getId(), product.getName(), product.getDescription(), AppUtils.doubleToVND(product.getPrice()));
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
    }

    private long inputId(InputOption option) {
        long id;
        switch (option) {
            case ADD:
                System.out.println("Nhập Id:");
                break;
            case UPDATE:
                System.out.println("Nhập id bạn muốn sửa:");
                break;
            case DELETE:
                System.out.println("Nhập id bạn muốn xoá:");
                break;
        }

        boolean isRetry = false;
        do {
            System.out.print(" => ");
            id = Long.parseLong(scanner.nextLine());
            boolean exist = productService.existsById(id);
            switch (option) {
                case ADD:
                    if (exist) System.out.println("Id này đã tồn tại. Vui lòng nhập id khác!");
                    isRetry = exist;
                    break;
                case UPDATE:
                    if (!exist) System.out.println("Không tìm thấy id! Vui lòng nhập lại");
                    isRetry = !exist;
                    break;
                case DELETE:
                    if (!exist) System.out.println("Không tìm thấy id! Vui lòng nhập lại");
                    isRetry = !exist;
            }
        } while (isRetry);
        return id;
    }

    public String inputProductName(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập tên sản phẩm: ");
                break;
            case UPDATE:
                System.out.println("Nhập tên sản phẩm bạn muốn sửa: ");
                break;
        }
        System.out.print(" => ");
        String productName = "";
        do {
            productName = scanner.nextLine();
            if (productName == null) {
                System.out.println("Không được để trống! Vui lòng nhập lại ");
                System.out.print(" => ");
                continue;
            }
            if (productService.existsByName(productName)) {
                System.out.println("Tên sản phẩm này đã tồn tại. Vui lòng nhập lại");
                System.out.print(" => ");
                continue;
            }
            break;
        } while (true);
        return productName;
    }

    public String inputDescription(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Mô tả sản phẩm: ");
                break;
            case UPDATE:
                System.out.println("Sửa mô tả sản phẩm: ");
                break;
        }
        System.out.print(" => ");
        String description = "";
        do {
            description = scanner.nextLine();
            if (description == null) {
                System.out.println("Không được để trống! Vui lòng nhập lại ");
                System.out.print(" => ");
                continue;
            }
            break;
        } while (true);
        return description;
    }

    public double inputPrice(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập giá sản phẩm:");
                break;
            case UPDATE:
                System.out.println("Nhập giá bạn muốn sửa");
                break;
        }
        System.out.print(" => ");
        double price;
        do {
            price = Double.parseDouble(scanner.nextLine());
            if (price < 1000) {
                System.out.println("Giá bán phải trên 1000đ! Vui lòng nhập lại ");
                System.out.print(" => ");
                continue;
            }
            break;
        } while (true);
        return price;
    }
}
