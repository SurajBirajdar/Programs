// 📦 This line tells Java which "folder" (package) this file lives in.
// Think of it like your home address — it helps Java find this file.
package programs.program.newPrograms.array;

// 📚 We are importing the Arrays class so we can use Arrays.toString()
// Arrays.toString() converts an array like {24,12,8,6} into a readable string "[24, 12, 8, 6]"
// Without this import, Java won't know what Arrays means.
import java.util.Arrays;

// 🏠 We are creating a public class (a blueprint / container) named ProductOfArrayExceptSelf.
// All our code lives inside this class.
public class ProductOfArrayExceptSelf {

    // 🚀 This is the main method — the ENTRY POINT of the program.
    // When you run this file, Java starts executing from here.
    public static void main(String[] args) {

        // 🧮 PROBLEM STATEMENT (what we want to solve):
        // Given an array, for each position, find the product of ALL OTHER elements EXCEPT the one at that position.
        // Example:
        //   Input  = {1, 2, 3, 4}
        //   For index 0 (value=1): product of 2*3*4 = 24
        //   For index 1 (value=2): product of 1*3*4 = 12
        //   For index 2 (value=3): product of 1*2*4 = 8
        //   For index 3 (value=4): product of 1*2*3 = 6
        //   Output = {24, 12, 8, 6}
        // ⚠️ IMPORTANT RULE: We CANNOT use division. We must do it in O(n) time.

        // 📝 Create an input array with 4 numbers: 1, 2, 3, 4
        int[] arr = {1, 2, 3, 4};

        // 🎯 Expected output after our logic runs: {24, 12, 8, 6}
        // output = {24, 12, 8, 6}

        // 📞 Call our helper method and store the result in 'ans'
        int[] ans = productOfArrayExceptSelf(arr);

        // 🖨️ Print the result array as a readable string, e.g., [24, 12, 8, 6]
        System.out.println(Arrays.toString(ans));
    }

    // ============================================================================================
    // 🧠 THE CORE LOGIC METHOD
    // ============================================================================================
    // This method takes the input array 'nums' and returns a new array where
    // each index contains the product of all elements EXCEPT the element at that index.
    //
    // 💡 KEY IDEA — We use TWO passes (loops):
    //   PASS 1 (Left to Right)  → For each index, store the product of ALL elements to its LEFT.
    //   PASS 2 (Right to Left)  → Multiply each index with the product of ALL elements to its RIGHT.
    //
    // After both passes, each index = (left product) * (right product) = product of everything except itself! ✅
    // ============================================================================================
    public static int[] productOfArrayExceptSelf(int[] nums) {

        // 📦 Create an output array 'ans' of the SAME SIZE as input array.
        // Right now all values are 0 by default in Java.
        // Example: nums = {1,2,3,4}, so ans = {0,0,0,0} initially.
        int[] ans = new int[nums.length];

        // ============================================================
        // 🔁 PASS 1: Fill 'ans' with PREFIX PRODUCTS (products of all elements to the LEFT)
        // ============================================================
        // For index 0, there is NOTHING to the left, so we set ans[0] = 1
        // (multiplying by 1 means "no contribution", like a neutral value)
        // Example: nums={1,2,3,4} → ans[0] = 1 (nothing to the left of index 0)
        ans[0] = 1;

        // ➡️ Start from index 1 and go to the end of the array.
        // At each step, ans[i] = product of all elements from index 0 to index (i-1)
        //
        // HOW? ans[i] = ans[i-1] * nums[i-1]
        //   → ans[i-1] already has the product of everything to the LEFT of (i-1)
        //   → We just multiply it by nums[i-1] to extend one more step to the left
        //
        // Step-by-step with nums={1,2,3,4}:
        //   i=1: ans[1] = ans[0] * nums[0] = 1 * 1 = 1   (only element to left of index 1 is nums[0]=1)
        //   i=2: ans[2] = ans[1] * nums[1] = 1 * 2 = 2   (elements to left of index 2 are 1,2 → product=2)
        //   i=3: ans[3] = ans[2] * nums[2] = 2 * 3 = 6   (elements to left of index 3 are 1,2,3 → product=6)
        //   After Pass 1: ans = {1, 1, 2, 6}
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // ============================================================
        // 🔁 PASS 2: Multiply 'ans' with SUFFIX PRODUCTS (products of all elements to the RIGHT)
        // ============================================================
        // 'suffix' is a running product of elements we've seen so far from the RIGHT side.
        // We start with suffix = 1 (neutral value, nothing seen yet from the right)
        int suffix = 1;

        // ⬅️ Start from the LAST index and go backwards to index 0.
        // At each step:
        //   ans[j] = ans[j] * suffix
        //     → ans[j] currently holds the LEFT product of index j (from Pass 1)
        //     → suffix currently holds the RIGHT product of index j
        //     → Multiply them together → we get product of ALL elements EXCEPT nums[j] ✅
        //   Then update suffix = suffix * nums[j]
        //     → Extend the suffix product one more step to the left for the next iteration
        //
        // Step-by-step with nums={1,2,3,4}, ans={1,1,2,6} after Pass 1:
        //   j=3: ans[3] = ans[3] * suffix = 6 * 1 = 6,    suffix = 1 * nums[3] = 1 * 4 = 4
        //   j=2: ans[2] = ans[2] * suffix = 2 * 4 = 8,    suffix = 4 * nums[2] = 4 * 3 = 12
        //   j=1: ans[1] = ans[1] * suffix = 1 * 12 = 12,  suffix = 12 * nums[1] = 12 * 2 = 24
        //   j=0: ans[0] = ans[0] * suffix = 1 * 24 = 24,  suffix = 24 * nums[0] = 24 * 1 = 24
        //   After Pass 2: ans = {24, 12, 8, 6}  ✅ CORRECT!
        for (int j = ans.length - 1; j >= 0; j--) {

            // 🔀 Multiply the existing left-product (stored in ans[j]) with the current right-product (suffix)
            ans[j] = ans[j] * suffix;

            // 🔄 Update suffix: include nums[j] in the running right-side product
            // This prepares 'suffix' for the next index (which is one step to the left)
            suffix = suffix * nums[j];
        }

        // 🎁 Return the final answer array.
        // Each index now contains the product of all elements EXCEPT the one at that index.
        return ans;
    }

    // ============================================================================================
    // 📊 COMPLEXITY ANALYSIS (Important for interviews!)
    // ============================================================================================
    // ⏱️ Time Complexity  : O(n)  — We loop through the array exactly TWICE (two passes).
    //                               n = number of elements in the array.
    // 🗂️ Space Complexity : O(1)  — We only use one extra variable 'suffix'.
    //                               The output array 'ans' doesn't count as extra space
    //                               because it IS the required output.
    // ============================================================================================
    //
    // 🎤 HOW TO EXPLAIN IN AN INTERVIEW (Simple Script):
    // --------------------------------------------------
    // "I use a two-pass approach.
    //  In the first pass (left to right), for each index I store the product of all elements
    //  to its LEFT in the answer array.
    //  In the second pass (right to left), I maintain a running 'suffix' product of elements
    //  to the RIGHT and multiply it into the answer array.
    //  After both passes, each index holds (left product × right product), which equals
    //  the product of all elements except itself.
    //  This runs in O(n) time and O(1) extra space — no division needed!"
    // ============================================================================================
}
