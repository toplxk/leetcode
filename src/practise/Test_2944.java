package practise;

/**
 * @author lixiaokai1
 * @description 购买水果需要的最少金币数
 * @date 2025/1/14 14:58
 */
public class Test_2944 {

    public int minimumCoins(int[] prices) {
        int[] memo = new int[(prices.length + 1) / 2];
        return dfs(prices, 1, memo);
    }

    private int dfs(int[] prices, int i, int[] memo) {
        if (i*2 >= prices.length) {
            return prices[i-1];
        }
        if (memo[i] != 0) {
            return memo[i];
        }
        int res = Integer.MAX_VALUE;
        for (int j = i + 1; j <= 2 * i + 1; j++) {
            res = Math.min(res, dfs(prices, j, memo));
        }
        memo[i] = res + prices[i-1];
        return memo[i];
    }

    public static void main(String[] args) {
        int[] prices = {26,18,6,12,49,7,45,45};
        Test_2944 test = new Test_2944();
        int res = test.minimumCoins(prices);
        System.out.println(res);
    }

}
