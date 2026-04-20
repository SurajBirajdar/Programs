package programs.program.YT;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] ans = productOfArrayExceptSelf(arr);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] productOfArrayExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int suffix = 1;
        for (int j = ans.length - 1; j >= 0; j--) {
            ans[j] = ans[j] * suffix;
            suffix = suffix * nums[j];
        }
        return ans;
    }
}
