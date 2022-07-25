package bai1;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> numberList=new MyList<Integer>();
        numberList.add(1);
        numberList.add(6);
        numberList.add(3);
        System.out.println(numberList.get(1));
    }
}
