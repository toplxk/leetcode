package practise;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lixiaokai1
 * @description
 * @date 2026/4/14 14:21
 */
public class Top_015 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3 || nums[0] > 0) return res;
        if (nums[0] == 0 && nums[nums.length - 1] == 0) {
            res.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
            return res;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                if (nums[j] + nums[k] == -nums[i]) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
                if (nums[j] + nums[k] < -nums[i]) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res.stream().distinct().collect(Collectors.toList());

    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,1};
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);
    }
}
