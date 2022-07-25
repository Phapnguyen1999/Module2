package bai4;

import java.util.*;

public class CountChart {
    public static void main(String[] args) {
        String example = "nguyen quoc phap nguyen phap";
        String[] arr = example.split(" ");
        TreeMap<String, Integer> map = new TreeMap<>();
        String key ="";
        int value;
        for (int i = 0; i < arr.length; i++) {
            key = arr[i].toLowerCase();
            if (map.containsKey(key)) {
                value = map.get(key);
                map.remove(key);
                map.put(key, value + 1);
            } else {
                map.put(key, 1);
            }
        }
        Object obj = new Object();
        Set set = map.keySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            key = (String) i.next();
            System.out.println(" Từ" +
                    " ' " + key + " ' xuất hiện "
                    + map.get(key) + " lần");
        }
    }
}
