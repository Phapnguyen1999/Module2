package vn.nqp.shop.model;

public class Product {
    private Long id;
    private String name;

    private String description;
    private Double price;

    public Product() {

    }

    public Product(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(long id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public static Product parseProduct(String record) {
        Product product = new Product();
        String[] fields = record.split(",");
        product.id = Long.parseLong(fields[0]);
        product.name = fields[1];
        product.description = fields[2];
        product.price = Double.parseDouble(fields[3]);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,", id, name, description, price);
    }

}
