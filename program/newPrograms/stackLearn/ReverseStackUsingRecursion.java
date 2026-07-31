package programs.program.newPrograms.stackLearn;

import java.util.Stack;

public class ReverseStackUsingRecursion {

    public static void pushAtBottom(Stack<Integer> st, int x) {
        if(st.size() == 0) {
            st.push(x);
            return;
        }
        int top = st.pop();
        pushAtBottom(st,x);
        st.push(top);
    }

    public static void reverseStack(Stack<Integer> st) {
        if(st.size() == 1) return;
        int top = st.pop();
        reverseStack(st);
        pushAtBottom(st,top);
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        System.out.println(st);
        reverseStack(st);
        System.out.println(st);
    }
}
