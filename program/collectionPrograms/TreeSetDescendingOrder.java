package programs.program.collectionPrograms;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDescendingOrder {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>();
        ts.add("suraj");
        ts.add("apurva");
        ts.add("rajabhau");

//        ts.forEach(e-> {
//            System.out.println(e);
//        });
//
//        for (String t : ts) {
//            System.out.println(t);
//        }

        Iterator<String> t = ts.iterator();
        while(t.hasNext()) {
            System.out.println(t.next());
        }


//        Iterator<String> it = ts.descendingIterator();
//        while(it.hasNext()) {
//            System.out.println(it.next());
//        }
    }
}
