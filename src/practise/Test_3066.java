package practise;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author lixiaokai1
 * @description 超过阈值的最少操作数 II
 * @date 2025/1/15 10:34
 */
public class Test_3066 {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add((long) num);
        }
        int ans = 0;
        while (queue.peek() < k) {
            long x = queue.poll();
            long y = queue.poll();
            long z = 2 * x + y;
            queue.offer(z);
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] nums = {999999999,999999999,999999999};
        int k = 1000000000;


        Test_3066 test_3066 = new Test_3066();
        int i = test_3066.minOperations(nums, k);
        System.out.println(i);
    }
}
