package programs.program.newPrograms.collectionPrograms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class HighestSalaryEmpFromListOfMap {
    public static void main(String[] args) {
        List<Map<String, Object>> employees = Arrays.asList(
                Map.of("name", "Sachin", "salary", 80000),
                Map.of("name", "Rohit", "salary", 95000),
                Map.of("name", "Virat", "salary", 120000),
                Map.of("name", "Rahul", "salary", 70000)
        );

        int maxSalary = Integer.MIN_VALUE;
        String name = "";
        int salary = 0;
        for(Map<String, Object> map : employees) {
            salary = (int) map.get("salary");
            if(salary > maxSalary) {
                maxSalary = salary;
                name = (String) map.get("name");
            }
        }
        System.out.println("Max salary is: " + maxSalary + " and name is: " + name);
    }
}
