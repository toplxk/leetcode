package practise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lixiaokai1
 * @description
 * @date 2026/4/11 23:53
 */
public class Top_001 {


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{0};
    }

}
