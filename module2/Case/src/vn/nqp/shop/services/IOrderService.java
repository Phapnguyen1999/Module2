package vn.nqp.shop.services;

import vn.nqp.shop.model.Order;

import java.util.List;

public interface IOrderService {
    boolean existsByIdOrderOfUser(long idOrder);

    boolean existsByIdOrder(long idOrder);

    List<Order> findAll();

    String findUserName();

    long findUserId();

    void addOrder(Order newOrder);

    List<Order> showOrder();

    void deleteByUser(long idOrder);

    void deleteByAd(long idOrder);
}
