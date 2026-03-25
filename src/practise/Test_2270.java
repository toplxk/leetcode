package practise;

/**
 * @author lixiaokai1
 * @description
 * @date 2025/1/13 16:02
 */
public class Test_2270 {
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        long[] temp = new long[nums.length];
        temp[0] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i > 0) {
                temp[i] = temp[i - 1] + nums[i];
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (temp[i] >= sum - temp[i]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 4, -8, 7};
        Test_2270 test_2270 = new Test_2270();
        int i = test_2270.waysToSplitArray(nums);
        System.out.println(i);
    }
}
