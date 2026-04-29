package practise;

import java.util.Arrays;

/**
 * @author lixiaokai1
 * @description
 * @date 2026/4/25 20:38
 */
public class Top_034 {
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums, target);
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        }
        int end = binarySearch(nums, target + 1) - 1;
        return  new int[]{first, end};
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
         while(left <= right) {
             int mid = left + (right - left) / 2;
             if (nums[mid] >= target) {
                 right = mid - 1;
             } else {
                 left = mid + 1;
             }
         }
         return  left;
    }

    public static void main(String[] args) {
        Top_034 top034 = new Top_034();
        int[] res = top034.searchRange(new int[]{2, 5, 6, 7, 8, 9, 10}, 9);
        System.out.println(Arrays.toString(res));
    }
}
