package practise;

import java.util.Arrays;

/**
 * @author lixiaokai1
 * @description
 * @date 2026/4/28 17:01
 */
public class Test_322 {

    public int coinChange(int[] coins, int amount) {
        int[] memn = new int[amount + 1];
        Arrays.fill(memn, -2);
        return dp(memn, coins, amount);
    }

    public int dp(int[] memn, int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        if(memn[amount] != -2) return memn[amount];

        int res = Integer.MAX_VALUE;
        for(int coin : coins) {
            int subProblem = dp(memn, coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, subProblem + 1);
        }
        memn[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return memn[amount];
    }

    public static void main(String[] args) {
        Test_322 test322 = new Test_322();
        int res = test322.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(res);
    }
}
