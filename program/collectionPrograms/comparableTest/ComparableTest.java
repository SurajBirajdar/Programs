package programs.program.collectionPrograms.comparableTest;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableTest {
    public static void main(String[] args) {
        ArrayList<Employee> emp = new ArrayList<>();
        emp.add(new Employee(2, "Suraj"));
        emp.add(new Employee(1,"Apurva"));

        Collections.sort(emp);
        System.out.println(emp);

    }
}
