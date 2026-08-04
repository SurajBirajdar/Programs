package programs.program.newPrograms.recursion;

public class HouseRobber {
    public static int solve(int[] arr, int index) {
        //base case
        if(index >= arr.length) return 0;
        //1 case hum solve karenge
        //baki recursion sambhal lega
        //main index wale house par hu
        //mere pass 2 choices hai, include or exclude
        //include - exclude pattern
        int includeAns = arr[index] + solve(arr, index+2);
        int excludeAns = 0 + solve(arr, index+1);
        return Math.max(includeAns,excludeAns);
    }

    public static void main(String[] args) {
        //House Robber problem
        int[] arr = {1,2,3,1};
        int index = 0;
        int ans = solve(arr,index);
        System.out.println(ans);
    }
}
