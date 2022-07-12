package menu.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Scanner;


public class ProductService {
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Product> soldProduct = new ArrayList<>();

    public ProductService() {
        products.add(new Product(126124, "iphone 8", 5, 8000000));
        products.add(new Product(126426, "iphone X", 6, 9000000));
        products.add(new Product(126125, "iphone X", 7, 9000000));
        products.add(new Product(126127, "iphone 11", 7, 10000000));
        products.add(new Product(126123, "iphone 12Pro", 7, 10000000));
        products.add(new Product(125126, "iphone 13Pro", 7, 10000000));
        products.add(new Product(123129, "iphone 13", 7, 10000000));
    }

    public ArrayList<Product> findAll() {
        return products;
    }

    public ArrayList<Product> soldProduct() {
        return soldProduct;
    }

    public void addProduct(Product newProduct) {
        newProduct.setId(System.currentTimeMillis() / 1000);
        findAll().add(newProduct);
    }

    public void addProductSold(Product newProduct) {
        soldProduct.add(newProduct);
    }

    public void updateProduct(Product newProduct) {
        for (Product product : findAll()) {
            if (product.getId() == newProduct.getId()) {
                String productName = newProduct.getName();
                if (productName != null) product.setName(productName);
                double productPrice = newProduct.getPrice();
                if (productPrice != 0) product.setPrice(productPrice);
                int productQuantity = newProduct.getQuantity();
                if (productQuantity != 0) product.setQuantity(productQuantity);
                break;
            }
        }
    }

    public boolean existsById(long productId) {
        for (Product product : findAll()) {
            if (product.getId() == productId) return true;
        }
        return false;
    }

    public boolean isNameInList(String name) {
        for (Product product : findAll()) {
            if (product.getName().equalsIgnoreCase(name)) return true;
        }
        return false;
    }

    public void deleteById(long productId) {
        findAll().removeIf(product -> product.getId() == productId);
    }

    public List<Product> sortByASC() {
        List<Product> newProducts = new ArrayList<>();
        newProducts.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                double result = o1.getPrice() - o2.getPrice();
                if (result == 0) return 0;
                return result > 0 ? 1 : -1;
            }
        });
        return newProducts;
    }

    public void sortByDESC() {

    }

    public void findProductByName(String name) {
        for (Product product : findAll()) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println(product);
            }
        }
    }

    public void buyProductByName(String nameProduct) {
        for (Product product : findAll()) {
            if (product.getName().equalsIgnoreCase(nameProduct)) {
                if (product.getQuantity() == 1) {
                    findAll().remove(product);
                }
                product.setQuantity(product.getQuantity() - 1);
//                System.out.printf(
//                        "\n\t%-16s%-36s%-26s%s\n\n",
//                        "Product Id",
//                        "Product Name",
//                        "Product Quantity",
//                        "Product Price"
//                );
//                System.out.printf(
//                        "\t%-16s %-36s %-26s%.2fđ\n",
//
//                        product.getId(),
//                        product.getName(),
//                        product.getQuantity(),
//                        product.getPrice()
//                );
//                Product newProduct = new Product(
//                        product.getId(),
//                        product.getName(),
//                        1,
//                        product.getPrice()
//                );
            }
        }
    }
}