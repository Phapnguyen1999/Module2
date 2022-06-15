package bai1;

public class TestStaticMethod {
    public static void main(String[] args) {
        Student.change();
        Student s1=new Student(123,"Phap Nha Nong");
        Student s2=new Student(234,"Trung Nha Que");
        Student s3=new Student(456, "Thanh Nha La");
        s1.display();
        s2.display();
        s3.display();
    }
}
