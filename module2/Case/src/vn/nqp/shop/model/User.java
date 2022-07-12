package vn.nqp.shop.model;

import vn.nqp.shop.utils.InstantUtils;

import javax.management.relation.Role;
import java.time.Instant;

public class User {
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String mobile;
    private String email;
    private String address;
    private Instant createdAt;
    private Instant updatedAt;

    public User() {
    }

    public User(String username, String password, String fullName, String mobile, String email, String address) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
    }

    public User(long id, String username, String password, String fullName, String mobile, String email, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
    }

    public static User parseUser(String raw) {
        User user = new User();
        String[] fields = raw.split(",");
        user.id = Long.parseLong(fields[0]);
        user.username = fields[1];
        user.password = fields[2];
        user.fullName = fields[3];
        user.mobile = fields[4];
        user.email = fields[5];
        user.address = fields[6];
        user.createdAt = Instant.parse(fields[7]);
        user.updatedAt = InstantUtils.parseInstant(fields[8]);
        return user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%s,%s,%s,%s,%s,%s,%s", id, username, password, fullName, mobile, email, address, createdAt, updatedAt);
    }
}
