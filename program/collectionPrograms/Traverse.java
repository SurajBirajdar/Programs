package programs.program.collectionPrograms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Traverse {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Suraj");
        names.add("Rajabhau");
        names.add("Maheshwari");
        names.add("Apurva");

        //forward traversion
        Iterator<String> itr = names.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println("-----------------------");
        //foreach method for traversal with lambda expression
        names.forEach(e->{
            System.out.println(e);
        });

        
    }
}
