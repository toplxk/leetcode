package practise;

import java.util.Arrays;

/**
 * @author lixiaokai1
 * @description
 * @date 2025/1/15 10:26
 */
public class Test_3065 {
    public int minOperations(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                ans += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] nums = {3, 6, 7, 2, 10};
        Test_3065 test_3065 = new Test_3065();
        int i = test_3065.minOperations(nums, 5);
        System.out.println(i);
    }
}
