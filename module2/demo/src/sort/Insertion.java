package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Insertion {

    public static void main(String[] args) {
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product(2321, "ip4", 41123));

        productList.add(new Product(3219, "ip2", 34667));
        productList.add(new Product(4534, "ip1", 25432));
        productList.add(new Product(3219, "Ip2", 34667));
        for (Product product : productList) {
            System.out.println(product.toString());
        }
//        Collections.sort(productList, new Comparator<Product>() {
//            @Override
//            public int compare(Product o1, Product o2) {
//                double result = o1.getPrice() - o2.getPrice();
//                if (result == 0) {
//                    result = o1.getId() - o2.getId();
//                    if (result == 0) {
//                        result = o1.compareTo(o2);
//                        if (result == 0) {
//                            return 0;
//                        }
//                        return result > 0 ? 1 : -1;
//                    }
//                    return result > 0 ? 1 : -1;
//                }
//                return result > 0 ? 1 : -1;
//            }
//        });
//        Collections.sort(productList, new Comparable<Product>() {
//            @Override
//            public int compareTo(Product o) {
//                return ;
//            }
//        });
//        insertionSort(productList);
//        System.out.println("after");
//        for (Product product : productList) {
//            System.out.println(product.toString());
//        }
    }

    public static void insertionSort(List<Product> list) {
        for (int i = 1; i < list.size(); i++) {
            int j = i;
            Product temp = new Product(list.get(i).getId(),list.get(i).getName(),list.get(i).getPrice());
            while (j > 0 && temp.getPrice() < list.get(j - 1).getPrice()) {
                list.get(j).setId(list.get(j - 1).getId());
                list.get(j).setName(list.get(j - 1).getName());
                list.get(j).setPrice(list.get(j - 1).getPrice());
                j--;
            }
            list.get(j).setId(temp.getId());
            list.get(j).setName(temp.getName());
            list.get(j).setPrice(temp.getPrice());
        }
    }
}
