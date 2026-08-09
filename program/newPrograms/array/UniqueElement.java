package programs.program.newPrograms.array;

public class UniqueElement {
    static int uniqueElement(int[] arr) {
        int xor = 0;
        for(int i=0; i<arr.length; i++) {
            xor = xor ^ arr[i];
        }
        return xor;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,1,2,6,8,6};
        int ans = uniqueElement(arr);
        System.out.println(ans);
    }
}
