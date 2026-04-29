package practise;

/**
 * @author lixiaokai1
 * @description 二分法分割后必定有一边是有序的，根据有序的部分判断目标值在哪边
 * @date 2026/4/21 15:58
 */
public class Top_033 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Top_033 top033 = new Top_033();
        int res = top033.search(new int[]{3,1}, 1);
        System.out.println(res);
    }
}

