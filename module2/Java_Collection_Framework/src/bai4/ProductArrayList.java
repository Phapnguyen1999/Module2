package bai4;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductArrayList {
    public ArrayList<Product> productList;

    public ProductArrayList() {
        ProductArrayList products = new ProductArrayList();
        Product nokia = new Product(1,"Nokia", 5500000);
        Product iphone = new Product( 2, "Iphone",7500000);
        Product samsung = new Product( 3, "SamSung", 7000000);
    }

    public void addProduct() {
        int id;
        String name;
        double price;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Product name: ");
            name = scanner.nextLine();
            if (isNameInList(name)) {
                System.out.println("Name already exists!!!");
            }
        } while (isNameInList(name));
        do {
            System.out.println("Product id: ");
            id = scanner.nextInt();
            if (isIdInList(id)) {
                System.out.println("ID already exists!!!");
            }
        } while (isIdInList(id));
        do {
            System.out.println("Product price: ");
            price = scanner.nextDouble();
            if (minPrice(price)) {
                System.out.println("Price Invalid!!!");
            }
        } while (minPrice(price));
        Product newProduct = new Product(id, name, price);
        productList.add(newProduct);
    }

    public boolean minPrice(double price) {
        if (price < 1000) {
            return true;
        }
        return false;
    }

    public boolean isNameInList(String name) {
        if (!productList.isEmpty()) {
            for (Product product : productList) {
                if (product.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isIdInList(int id) {
        if (!productList.isEmpty()) {
            for (Product product : productList) {
                if (product.getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }

    public void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        if (productList.isEmpty()) {
            System.out.println("List is empty!!!");
            return;
        }
        System.out.println("Enter id you want to delete: ");
        int id = scanner.nextInt();
        int tempid=-1;
        if (isIdInList(id)) {
            for (Product product : productList) {
                if (product.getId() == id) {
                    System.out.println("Remove product: " + product.toString());
                    tempid= productList.indexOf(product);
                }
            }
            productList.remove(tempid);
        } else {
            System.out.println("ID invalid!!!");
        }
    }
    public void setProductInList(){
        if (productList.isEmpty()){
            System.out.println("List id empty!!!");
            return;
        }
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter id you want to edit: ");
        int id= scanner.nextInt();
        if(isIdInList(id)){
            for (Product product:productList){
                if (product.getId()==id){
                    System.out.println("Choice the number: ");
                    int choice;
                    boolean cont=true;
                    do {
                        System.out.println("Menu edit Product");
                        System.out.println("1. Edit name product");
                        System.out.println("2. Edit id product");
                        System.out.println("3. Edit price Product");
                        System.out.println("0. Exit");
                        choice= scanner.nextInt();
                        switch (choice){
                            case 1:
                                System.out.print("New name: ");
                                String newName= scanner.nextLine();
                                product.setName(newName);
                                break;
                            case 2:
                                System.out.print("New id: ");
                                int newId= scanner.nextInt();
                                product.setId(newId);
                                break;
                            case 3:
                                System.out.print("New price: ");
                                double newPrice= scanner.nextDouble();
                                product.setPrice(newPrice);
                                break;
                            case 0:
                                cont=false;
                                break;
                            default:
                                System.out.println("Enter number again!!!");
                        }
                    }while (cont);
                }
            }
        }
    }
    public void renderProduct(){
        if(productList.isEmpty()){
            System.out.println("List is empty!!!");
            return;
        }
        for (Product product:productList){
            System.out.println(product.toString());
        }
    }
}
