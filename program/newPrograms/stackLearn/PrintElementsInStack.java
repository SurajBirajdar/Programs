package programs.program.newPrograms.stackLearn;

import java.util.Stack;

public class PrintElementsInStack {
    static void printRecursion(Stack<Integer> st) {
        if(st.size() == 0) return;
        int x = st.pop();
        System.out.print(x + " ");
        printRecursion(st);
        st.push(x);
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        // print Elements in stack
        Stack<Integer> rt = new Stack<>();
        while(st.size() > 0) {
            rt.push(st.pop());
        }

        while(rt.size() > 0) {
            System.out.print(rt.peek() + " ");
            st.push(rt.pop());
        }
        System.out.println();

        // printing elements in reverse way by pushing elements to array first from st
        int n = st.size();
        int[] arr = new int[n];
        for(int i = n-1; i>=0; i--) {
            arr[i] = st.pop();
        }
        for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
            st.push(arr[i]);
        }
        System.out.println();
        printRecursion(st);
    }
}
