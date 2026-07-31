package programs.program.newPrograms.stackLearn;

public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            ans[i] = -1;
            for(int j = i+1; j<n; j++) {
                if(arr[j] > arr[i]) {
                    ans[i] = arr[j];
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,1,8,6,3,4};
        int[] res = nextGreaterElement(arr); // using two for loops
        for(int i=0; i<res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
