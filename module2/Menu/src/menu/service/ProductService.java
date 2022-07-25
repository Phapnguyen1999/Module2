package menu.service;

import menu.model.Product;
import menu.utils.CSVUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;


public class ProductService {
    public final static String PATH = "data/products.csv";
    private static ProductService instance;

    public ProductService() {

    }

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        List<String> records = CSVUtils.read(PATH);
        for (String record : records) {
            products.add(Product.parseProduct(record));
        }
        return products;
    }


    public void addProduct(Product newProduct) {
        List<Product> products = findAll();
        newProduct.setId(System.currentTimeMillis() / 1000);
        products.add(newProduct);
        CSVUtils.write(PATH, products);
    }

    public void updateProduct(Product newProduct) {
        List<Product> products=findAll();
        for (Product product : products) {
            if (product.getId() == newProduct.getId()) {
                String productName = newProduct.getName();
                if (productName != null) product.setName(productName);
                double productPrice = newProduct.getPrice();
                if (productPrice != 0) product.setPrice(productPrice);
                int productQuantity = newProduct.getQuantity();
                if (productQuantity != 0) product.setQuantity(productQuantity);
                CSVUtils.write(PATH, products);
                break;
            }
        }
    }

    public boolean existsById(long productId) {
        List<Product> products = findAll();
        for (Product product : products) {
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
        List<Product> products = findAll();
        for (Product product : products) {
            if (product.getId() == (productId))
                products.remove(product);
            CSVUtils.write(PATH, products);
            return;
        }
    }

    public Product findById(long id) {
        List<Product> products = findAll();
        for (Product product : products) {
            if (product.getId() == (id)) return product;
        }
        return null;
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

    public List<Product> findProductByName(String name) {
        List<Product> newProducts = new ArrayList<>();
        List<Product> products = findAll();
        for (Product product : products)
            if (product.getName().equalsIgnoreCase(name)) {
                newProducts.add(product);
            }
        return newProducts;
    }
}