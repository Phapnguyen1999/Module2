package vn.nqp.shop.model;

import vn.nqp.shop.utils.InstantUtils;

import java.time.Instant;

public class Order {
    private long id;
    private long userId;

    private String userName;
    private long productId;

    private String productName;
    private int quantity;
    private double price;
    private double total;
    private Instant createdAt;

    public Order() {
    }

    public Order(long productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public Order(long id, long userId, String userName, long productId, String productName, int quantity, double price, double total, Instant createdAt) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
        this.createdAt = createdAt;
    }

    public Order(long id, long userId, String userName, long productId, String productName, int quantity, double price, Instant createdAt) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.createdAt = createdAt;
    }


    public static Order parseOrder(String record) {
        String[] fields = record.split(",");
        long id = Long.parseLong(fields[0]);
        long userId = Long.parseLong(fields[1]);
        String userName = fields[2];
        long productId = Long.parseLong(fields[3]);
        String productName = fields[4];
        int quantity = Integer.parseInt(fields[5]);
        double price = Double.parseDouble(fields[6]);
        double total = Double.parseDouble(fields[7]);
        Instant createdAt = InstantUtils.parseInstant(fields[8]);
        return new Order(id, userId, userName, productId, productName, quantity, price, total, createdAt);
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", id, userId, userName, productId, productName, quantity, price, total, createdAt);
    }
}
