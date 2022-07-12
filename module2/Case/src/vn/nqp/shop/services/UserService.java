package vn.nqp.shop.services;

import vn.nqp.shop.model.User;
import vn.nqp.shop.utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public final static String PATH = "data/users.csv";
    public final static String USER_LOGIN = "data/loginlist.csv";
    private static UserService instance;

    public UserService() {

    }

    public static UserService getInstance() {
        if (instance == null)
            instance = new UserService();
        return instance;
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        List<String> records = CSVUtils.read(PATH);
        for (String record : records) {
            users.add(User.parseUser(record));
        }
        return users;
    }

    public boolean checkAccount(String userName, String password) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getUsername().equals(userName) && user.getPassword().equals(password)) {
                List<User> loginList = new ArrayList<>();
                loginList.add(user);
                CSVUtils.write(USER_LOGIN, loginList);
                return true;
            }
        }
        return false;
    }
}
