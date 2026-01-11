package programs.program.collectionPrograms.ComparatorTest;
import java.util.*;
public class IdComparator implements Comparator<Student>{

    public int compare(Student student1, Student student2) {
        return student2.getRollNumber() - student1.getRollNumber();
    }
}
