package programs.program.collectionPrograms.ComparatorTest;

import java.util.*;
public class ComparatorTest {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(34,"Suraj"));
        studentList.add(new Student(56,"Atharva"));

        Collections.sort(studentList, new IdComparator());
        studentList.sort(new NameComparator());
        System.out.println(studentList);
    }
}
