package programs.program.newPrograms.stackLearn;

import java.util.Stack;

public class RemoveConsecutiveConseq {
    public static int[] remove(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            ans[i] = -1;
            if(stack.size() == 0 || stack.peek() != arr[i]) {
                stack.push(arr[i]);
            } else if(stack.peek() == arr[i] && i<arr.length-1) {
                if(arr[i] != arr[i+1]) {
                    stack.pop();
                }
            }
        }
        int[] res = new int[stack.size()];
        int n = res.length;
        for(int i=n-1; i>=0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,10,10,10,4,4,4,5,7,7,2};
        int[] ans = remove(arr);
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
