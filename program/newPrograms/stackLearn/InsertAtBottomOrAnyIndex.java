package programs.program.newPrograms.stackLearn;

import java.util.Stack;

public class InsertAtBottomOrAnyIndex {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        // insert 5 at index 2
        int index = 2;
        int value = 5;
        Stack<Integer> temp =new Stack<>();
        while(st.size() > index) {
            temp.push(st.pop());
        }
        st.push(value);

        while(temp.size() > 0) {
            st.push(temp.pop());
        }
        System.out.println(st);
    }
}
