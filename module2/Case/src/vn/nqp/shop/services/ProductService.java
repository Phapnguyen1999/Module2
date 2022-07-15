package vn.nqp.shop.services;

import vn.nqp.shop.model.Product;
import vn.nqp.shop.utils.CSVUtils;

import java.util.*;

public class ProductService implements IProductService {
    public final static String PATH = "data/product.csv";
    private static ProductService instance;

    public ProductService() {

    }

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        List<String> records = CSVUtils.read(PATH);
        for (String record : records) {
            products.add(Product.parseProduct(record));
        }
        return products;
    }

    @Override
    public void addProduct(Product newProduct) {
        List<Product> products = findAll();
        newProduct.setId(System.currentTimeMillis() / 1000);
        products.add(newProduct);
        CSVUtils.write(PATH, products);
    }

    @Override
    public void updateProduct(Product newProduct) {
        List<Product> products = findAll();
        for (Product product : products) {
            if (product.getId() == newProduct.getId()) {
                String productName = newProduct.getName();
                if (productName != null && !productName.isEmpty()) product.setName(productName);
                String descriptionProduct = newProduct.getDescription();
                if (descriptionProduct != null) product.setDescription(descriptionProduct);
                Double productPrice = newProduct.getPrice();
                if (productPrice != null) product.setPrice(productPrice);
                CSVUtils.write(PATH, products);
                break;
            }
        }
    }

    @Override
    public boolean existsById(long id) {
        List<Product> products = findAll();
        for (Product product : products) {
            if (product.getId() == id)
                return true;
        }
        return false;
    }

    @Override
    public boolean existsByName(String name) {
        for (Product product : findAll()) {
            if (product.getName().equalsIgnoreCase(name)) return true;
        }
        return false;
    }

    @Override
    public void deleteById(long id) {
        List<Product> products = findAll();
        List<Product> list = new ArrayList<>();
        for (Product product : products) {
            if (product.getId() != id) list.add(product);
        }
        CSVUtils.write(PATH, list);
    }

    //    public Product findById(long id) {
//        List<Product> products = findAll();
//        for (Product product : products) {
//            if (product.getId() == (id)) return product;
//        }
//        return null;
//    }
    @Override
    public List<Product> sortByASC() {
        List<Product> newProducts = findAll();
        Collections.sort(newProducts, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                double result = o1.getPrice() - o2.getPrice();
                if (result == 0) return 0;
                return result > 0 ? 1 : -1;
            }
        });
        return newProducts;
    }

    @Override
    public List<Product> findProductByName(String name) {
        List<Product> newProducts = new ArrayList<>();
        List<Product> products = findAll();
        for (Product product : products)
            if (product.getName().toLowerCase().contains(name.toLowerCase()))
                newProducts.add(product);
        return newProducts;
    }
}
