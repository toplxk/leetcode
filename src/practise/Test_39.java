package practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixiaokai1
 * @description
 * @date 2024/7/5 14:10
 */
public class Test_39 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        for (int i = 0; i < candidates.length; i++) {
            List<Integer> list = new ArrayList<>();
            helper(candidates, list, target);
        }
        return res;
    }
    public void helper(int[] candidates, List<Integer> list, int target) {
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] == target) {
                res.add(new ArrayList<>(list));
                list.remove(i - 1);
                continue;
            }
            if (candidates[i] > target) {
                list.remove(i - 1);
                continue;
            }
            list.add(candidates[i]);
            helper(candidates, list, target - candidates[i]);
        }
    }
    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = new Test_39().combinationSum(nums, target);
        System.out.println(res);
    }
}
