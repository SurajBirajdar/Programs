package programs.program.newPrograms.array;

public class MissingNumber {
    static int getMissingNumber(int[] arr) {
        int xorsum = 0;
        for(int i=0; i<arr.length; i++) {
            xorsum = xorsum ^ arr[i];
        }
        for(int i=0; i<7; i++) {
            xorsum = xorsum ^ i;
        }
        return xorsum;
    }
    public static void main(String[] args) {
        //Missing number
        int[] arr = {0,2,1,3,5,6};
        int ans = getMissingNumber(arr);
        System.out.println(ans);
    }
}
