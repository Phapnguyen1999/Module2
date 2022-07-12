package vn.nqp.shop.services;

import vn.nqp.shop.model.User;

import java.util.List;

public interface IUserServiceByAd {
    List<User> findAll();

    void addUser(User newUser);

    void updateUser(User newUser);

    void deleteById(long idUser);

    User findById(long idUser);

    boolean existById(long id);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    boolean existsByUsername(String userName);
}
