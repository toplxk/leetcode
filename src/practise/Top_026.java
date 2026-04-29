package practise;

/**
 * @author lixiaokai1
 * @description
 * @date 2026/4/20 16:13
 */
public class Top_026 {

    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        Top_026 obj = new Top_026();
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int res = obj.removeDuplicates(nums);
        System.out.println(res);
    }
}
