package bai2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Student students = new Student("Trung", "Thuan An", 24);
        Student student2 = new Student("Thanh", "hue", 27);
        Student student3 = new Student("Phap", "viet nam", 22);
        Student student4 = new Student("Thien", "campuchia", 13);

        Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(1, students);
        studentMap.put(2, student2);
        studentMap.put(3, student3);
        studentMap.put(1, student4);

        for (Map.Entry<Integer, Student> student : studentMap.entrySet()) {
            System.out.println(student.toString());
        }

        System.out.println("...........Set");
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(students);
        studentSet.add(student2);
        studentSet.add(student3);
        studentSet.add(student4);
        for (Student student: studentSet) {
            System.out.println(student.toString());
        }
    }
}
