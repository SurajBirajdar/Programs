package programs.program.collectionPrograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class sortCustomClass {

    public static void main(String[] args) {
        ArrayList<Student> arrList = new ArrayList<Student>();
        Student s1 = new Student(2,"suraj");
        Student s2 = new Student(6,"apurva");
        Student s3 = new Student(7,"rajabhau");
        Student s4 = new Student(3,"maheshwari");

        arrList.add(s1);
        arrList.add(s2);
        arrList.add(s3);
        arrList.add(s4);
        System.out.println(arrList.toString());
        //NameComparator nc = new NameComparator();
        rollNoComparator rc = new rollNoComparator();
        Collections.sort(arrList,rc);
        System.out.println(arrList.toString());


    }


}
class Student{
    public int rollNO;
    public String name;

    Student(int rollNo, String name){
        this.rollNO = rollNo;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNO=" + rollNO +
                ", name='" + name + '\'' +
                '}';
    }


//    @Override
//    public int compareTo(Student o) {
//        return this.rollNO - o.rollNO;
//    }
}

class rollNoComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.rollNO - o2.rollNO;
    }
}
