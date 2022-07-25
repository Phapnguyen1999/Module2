package menu.service;

import menu.model.User;
import menu.utils.CSVUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public final static String PATH = "data/users.csv";
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

    public void add(User newUser) {
        newUser.setId(System.currentTimeMillis() / 1000);
        newUser.setCreatedAt(Instant.now());
        newUser.setUpdatedAt(Instant.now());
        List<User> users = findAll();
        users.add(newUser);
        CSVUtils.write(PATH, users);
    }

    public void updateUSer(User newUser) {
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
    public void deleteById(long idUser){
        List<User> users=findAll();
        for(User user:users){
            if (user.getId()==idUser){
                users.remove(idUser);
            }
        }
        CSVUtils.write(PATH,users);
    }
    public User findById(long idUser){
        List<User> users = findAll();
        for (User user : users) {
            if (user.getId() == idUser)
                return user;
        }
        return null;
    }
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

    public boolean existsByPhone(String phone) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getMobile().equals(phone))
                return true;
        }
        return false;
    }

    public boolean existsByUsername(String userName) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getUsername().equals(userName))
                return true;
        }
        return false;
    }
}
