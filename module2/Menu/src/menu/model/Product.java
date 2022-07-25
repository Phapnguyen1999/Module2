package menu.model;

import menu.service.ProductService;

public class Product {
    private long id;
    private String name;
    private int quantity;
    private double price;

    public Product(long id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public Product(){

    }

    public static Product parseProduct(String raw) {
        Product product=new Product();
        String[] fields = raw.split(",");
        product.id = Long.parseLong(fields[0].trim());
        product.name = fields[1].trim();
        product.quantity = Integer.parseInt(fields[2].trim());
        product.price = Double.parseDouble(fields[3].trim());
        return product;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
