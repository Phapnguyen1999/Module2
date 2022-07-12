package vn.nqp.shop.services;

import vn.nqp.shop.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void addProduct(Product newProduct);

    void updateProduct(Product newProduct);

    boolean existsById(long id);

    boolean existsByName(String name);

    void deleteById(long id);

    List<Product> findProductByName(String name);

    List<Product> sortByASC();
}
