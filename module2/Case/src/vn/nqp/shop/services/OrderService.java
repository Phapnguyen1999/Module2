package vn.nqp.shop.services;

import vn.nqp.shop.model.Order;
import vn.nqp.shop.model.User;
import vn.nqp.shop.utils.CSVUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderService implements IOrderService {
    public final static String PATH = "data/orderlist.csv";
    public final static String USER_LOGIN = "data/loginlist.csv";
    public final static String CONFIRM_LIST = "data/confirmlist.csv";
    private static OrderService instance;

    public OrderService() {

    }

    public static OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    @Override
    public boolean existsByIdOrderOfUser(long idOrder) {
        List<Order> orders = showOrder();
        for (Order order : orders) {
            if (order.getId() == idOrder)
                return true;
        }
        return false;
    }

    @Override
    public boolean existsByIdOrder(long idOrder) {
        List<Order> orders = findAll();
        for (Order order : orders) {
            if (order.getId() == idOrder)
                return true;
        }
        return false;
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        List<String> records = CSVUtils.read(PATH);
        for (String record : records) {
            orders.add(Order.parseOrder(record));
        }
        return orders;
    }
    public List<Order> confimList() {
        List<Order> orders = new ArrayList<>();
        List<String> records = CSVUtils.read(CONFIRM_LIST);
        for (String record : records) {
            orders.add(Order.parseOrder(record));
        }
        return orders;
    }


    @Override
    public String findUserName() {
        String result = null;
        List<User> users = new ArrayList<>();
        List<String> records = CSVUtils.read(USER_LOGIN);
        for (String record : records) {
            users.add(User.parseUser(record));
        }
        for (User user : users) {
            result = user.getUsername();
        }
        return result;
    }

    @Override
    public long findUserId() {
        long result = 0;
        List<User> users = new ArrayList<>();
        List<String> records = CSVUtils.read(USER_LOGIN);
        for (String record : records) {
            users.add(User.parseUser(record));
        }
        for (User user : users)
            result = user.getId();
        return result;
    }

    @Override
    public void addOrder(Order newOrder) {
        List<Order> orders = findAll();
        newOrder.setId(System.currentTimeMillis() / 1000);
        newOrder.setUserId(findUserId());
        newOrder.setUserName(findUserName());
        newOrder.setCreatedAt(Instant.now());
        newOrder.setTotal(newOrder.getQuantity() * newOrder.getPrice());
        orders.add(newOrder);
        CSVUtils.write(PATH, orders);
    }

    @Override
    public List<Order> showOrder() {
        List<Order> orders = findAll();
        List<Order> list = new ArrayList<>();
        for (Order order : orders) {
            if (order.getUserName().equals(findUserName())) {
                list.add(order);
            }
        }
        return list;
    }

    @Override
    public void deleteByUser(long idOrder) {
        List<Order> orders = showOrder();
        List<Order> list = new ArrayList<>(orders);
        for (Order order : orders) {
            if (order.getId() == idOrder) {
                list.remove(order);
            }
        }
        CSVUtils.write(PATH, list);
    }

    @Override
    public void deleteByAd(long idOrder) {
        List<Order> orders = findAll();
        List<Order> list = new ArrayList<>(orders);
        for (Order order : orders) {
            if (order.getId() == idOrder) {
                list.remove(order);
            }
        }
        CSVUtils.write(PATH, list);
    }
    public void confirmOrder(long idOrder){
        List<Order> orders = findAll();
        List<Order> list = new ArrayList<>(orders);
        List<Order> confirmLists=confimList();
        for (Order order : orders) {
            if (order.getId() == idOrder) {
                confirmLists.add(order);
                list.remove(order);
            }
        }
        CSVUtils.write(PATH, list);
        CSVUtils.write(CONFIRM_LIST,confirmLists);
    }

}
