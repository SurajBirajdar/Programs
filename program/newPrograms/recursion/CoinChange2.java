package programs.program.newPrograms.recursion;

public class CoinChange2 {
    static int solve(int amount, int[] coins, int index) {
        if(amount == 0) {
            return 1;
        }
        if(amount < 0) {
            return 0;
        }
        if(index >= coins.length) {
            return 0;
        }
        int includeKaAns = solve(amount - coins[index], coins, index);
        int excludeKaAns = solve(amount, coins, index+1);
        int ans = includeKaAns + excludeKaAns;
        return ans;
    }

    public static void main(String[] args) {
        int index = 0;
        int amount = 5;
        int[] coins = {1,2,5};
        int ans = solve(amount, coins, index);
        System.out.println("Number of ways of coin changes to make particular amount is : " + ans);
    }
}
