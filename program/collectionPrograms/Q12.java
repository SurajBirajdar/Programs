package programs.program.collectionPrograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class Q12 {
    public static void main(String[] args) {

            ArrayList<Human> al=new ArrayList<Human>();
            al.add(new Human(20,1));
            al.add(new Human(25,8));
            al.add(new Human(30,3));
            al.add(new Human(4,47));

            TreeSet<Human> s = new TreeSet<>();
            s.addAll(al);
            for(Human n : s) {
                System.out.println(n);
            }

            Collections.sort(al,new Comparator<Human>() {
                public int compare(Human h1,Human h2) {
                    Integer i1=h1.age;
                    Integer i2=h2.age;
                    return i2.compareTo(i1);
                }
            });
            al.forEach(e->{
                System.out.println(e);
            });
        }
    }


    class Human{
        int age;
        int roll;
        Human(int a,int b){
            this.age=a;
            this.roll=b;
        }
    }

