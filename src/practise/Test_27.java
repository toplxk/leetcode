package practise;

/**
 * @author lixiaokai1
 * @description
 * @date 2024/7/4 20:02
 */
public class Test_27 {
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != val) {
                nums[i] = nums[k];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int res = removeElement(nums, 2);
        System.out.println(res);
    }
}
