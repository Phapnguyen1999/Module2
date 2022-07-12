package vn.nqp.shop.views;

import vn.nqp.shop.model.Order;
import vn.nqp.shop.model.Product;
import vn.nqp.shop.services.OrderService;
import vn.nqp.shop.services.ProductService;
import vn.nqp.shop.utils.AppUtils;

import java.util.List;
import java.util.Scanner;

public class OrderView {
    public OrderService orderService;
    public ProductService productService;
    private static final Scanner scanner = new Scanner(System.in);

    public OrderView() {
        orderService = OrderService.getInstance();
        productService = ProductService.getInstance();
    }

    public void showProduct() {
        ProductView productView = new ProductView();
        productView.showProducts();
    }

    public void addOrder() {
        long idProduct;
        String nameProduct = null;
        double price = 0;
        int quantity;
        do {
            System.out.print("Nhập ID sản phẩm: ");
            idProduct = Long.parseLong(scanner.nextLine());
            if (!productService.existsById(idProduct)) {
                System.out.println("Sản phẩm không có trong cửa hàng: ");
                continue;
            }
            break;
        } while (true);
        do {
            System.out.print("Nhập số lượng: ");
            quantity = Integer.parseInt(scanner.nextLine());
            if (quantity < 0) {
                System.out.println("Xin mời nhập lại số lượng ");
                continue;
            }
            break;
        } while (true);
        List<Product> list = productService.findAll();
        for (Product product : list) {
            if (product.getId() == idProduct) {
                nameProduct = product.getName();
                price = product.getPrice();
            }
        }
        Order newOrder = new Order(idProduct, nameProduct, quantity, price);
        orderService.addOrder(newOrder);
        System.out.println("\n Order đã được tạo thành công!");
    }

    public void showOrderbyUser() {
        System.out.println("--------------------------------------------- DANH SÁCH ORDER------------------------------------------------- ");
        System.out.printf("%-15s %-22s %-15s %-22s %-15s %-20s %-20s %-20s %-20s\n", "Order Id", "User Id", "User Name", "Product ID", "Product Name", "Product Quantity", "Product Price", "Total", "CreateAt");
        List<Order> orders = orderService.showOrder();
        for (Order order : orders) {
            System.out.printf("%-15s %-22s %-15s %-22s %-15s %-20s %-20s %-20s %-20s\\n", order.getId(), order.getUserId(), order.getUserName(), order.getProductId(), order.getProductName(), order.getQuantity(), AppUtils.doubleToVND(order.getPrice()), AppUtils.doubleToVND(order.getTotal()), order.getCreatedAt());
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------- ");
    }

    public void deleteOrder() {
        long idOrder;
        do {
            System.out.print("Nhập ID Order muốn xoá: ");
            idOrder = Long.parseLong(scanner.nextLine());
            if (!orderService.existsByIdOrderOfUser(idOrder)) {
                System.out.println("ID không có trong danh sách! Mời nhập lại");
                continue;
            }
            System.out.println("Xoá order thành công");
            break;
        } while (true);
        orderService.deleteByUser(idOrder);
    }

    public void showAllOrder() {
        System.out.println("--------------------------------------------- DANH SÁCH ORDER----------------------------------------------------------------------------------------------- ");
        System.out.printf("%-15s %-22s %-15s %-22s %-15s %-20s %-20s %-20s %-20s\n", "Order Id", "User Id", "User Name", "Product ID", "Product Name", "Product Quantity", "Product Price", "Total", "CreateAt");
        List<Order> orders = orderService.findAll();
        for (Order order : orders) {
            System.out.printf("%-15s %-22s %-15s %-22s %-15s %-20s %-20s %-20s %-20s\n", order.getId(), order.getUserId(), order.getUserName(), order.getProductId(), order.getProductName(), order.getQuantity(), AppUtils.doubleToVND(order.getPrice()), AppUtils.doubleToVND(order.getTotal()), order.getCreatedAt());
            System.out.println();
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------- ");
    }

    public void deleteOrderByAd() {
        long idOrder;
        do {
            System.out.print("Nhập ID Order muốn xoá: ");
            idOrder = Long.parseLong(scanner.nextLine());
            if (!orderService.existsByIdOrder(idOrder)) {
                System.out.println("ID không có trong danh sách! Mời nhập lại");
                continue;
            }
            System.out.println("Xoá order thành công");
            break;
        } while (true);
        orderService.deleteByAd(idOrder);
    }
}
