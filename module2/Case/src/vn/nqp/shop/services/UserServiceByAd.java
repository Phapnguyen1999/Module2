package vn.nqp.shop.services;

import vn.nqp.shop.model.User;
import vn.nqp.shop.utils.CSVUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class UserServiceByAd implements IUserServiceByAd {
    public final static String PATH = "data/users.csv";
    private static UserServiceByAd instance;

    public UserServiceByAd() {

    }

    public static UserServiceByAd getInstance() {
        if (instance == null)
            instance = new UserServiceByAd();
        return instance;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        List<String> records = CSVUtils.read(PATH);
        for (String record : records) {
            users.add(User.parseUser(record));
        }
        return users;
    }

    @Override
    public void addUser(User newUser) {
        List<User> users = findAll();
        newUser.setCreatedAt(Instant.now());
        newUser.setUpdatedAt(Instant.now());
        users.add(newUser);
        CSVUtils.write(PATH, users);
    }

    @Override
    public void updateUser(User newUser) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getId() == newUser.getId()) {
                String fullName = newUser.getFullName();
                if (fullName != null && !fullName.isEmpty())
                    user.setFullName(fullName);
                String phone = newUser.getMobile();
                if (phone != null && !phone.isEmpty())
                    user.setMobile(newUser.getMobile());
                String address = newUser.getAddress();
                if (address != null && !address.isEmpty())
                    user.setAddress(newUser.getAddress());
                user.setUpdatedAt(Instant.now());
                CSVUtils.write(PATH, users);
                break;
            }
        }
    }

    @Override
    public void deleteById(long idUser) {
        List<User> users = findAll();
        List<User> list = new ArrayList<>(users);
        for (User user : users) {
            if (user.getId() == idUser) {
                list.remove(user);
            }
        }
        CSVUtils.write(PATH, list);
    }

    @Override
    public User findById(long idUser) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getId() == idUser)
                return user;
        }
        return null;
    }

    @Override
    public boolean existById(long id) {
        return findById(id) != null;
    }

    public boolean existsByEmail(String email) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getEmail().equals(email))
                return true;
        }
        return false;
    }

    @Override
    public boolean existsByPhone(String phone) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getMobile().equals(phone))
                return true;
        }
        return false;
    }

    @Override
    public boolean existsByUsername(String userName) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getUsername().equals(userName))
                return true;
        }
        return false;
    }
}
