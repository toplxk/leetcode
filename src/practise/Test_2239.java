package practise;

/**
 * @author lixiaokai1
 * @description
 * @date 2025/1/20 20:01
 */
public class Test_2239 {
    public int findClosestNumber(int[] nums) {
        Integer min = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) < Math.abs(min)) {
                min = nums[i];
                if (Math.abs(min) < Math.abs(ans) || Math.abs(min) == Math.abs(ans)) {
                    ans = min;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array = {-4, -2, 1, 4, 8};
        Test_2239 test_2239 = new Test_2239();
        int i = test_2239.findClosestNumber(array);
        System.out.println(i);
    }
}
