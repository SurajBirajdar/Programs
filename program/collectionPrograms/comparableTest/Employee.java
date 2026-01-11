package programs.program.collectionPrograms.comparableTest;

public class Employee implements Comparable<Employee> {
    private int id;
    private String name;

//    public int compareTo(Employee emp) {
//        return this.getId() - emp.getId();
//    }

    public int compareTo(Employee emp) {
        return this.getName().compareTo(emp.getName());
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
