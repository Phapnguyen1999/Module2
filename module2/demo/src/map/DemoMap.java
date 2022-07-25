package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DemoMap {
    public static void main(String[] args) {
        Map<String,Integer> map =new HashMap<String,Integer>();
        // Them phan tu vao map
        map.put("A",2);
        map.put("E",6);
        map.put("B",4);
        map.put("C",3);
        map.put("B",1);

//        lay gia tri cua 1 key
        System.out.println(map.get("B"));
//        lay ra tap hop cac key
        Set<String> keySet=map.keySet();
        for (String i: keySet){
            System.out.println(i+" "+map.get(i));
        }
        System.out.println();
//        xoa 1 phan tu
        map.remove("E");
        Set<String> keySet2=map.keySet();
        for (String i: keySet2){
            System.out.println(i+" "+map.get(i));
        }
//        xao toan bo map
        System.out.println("***************");
//        map.clear();
//        Set<String> keySet3=map.keySet();
//        for (String i: keySet3){
//            System.out.println(i+" "+map.get(i));
//        }
        for (Map.Entry<String,Integer> i : map.entrySet()){
            System.out.print(i.getKey());
            System.out.println(i.getValue());
        }
    }
}
