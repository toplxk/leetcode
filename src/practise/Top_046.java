package practise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lixiaokai1
 * @description
 * @date 2026/4/26 15:24
 */
public class Top_046 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList();
        backTrack(nums, track);
        return res;
    }

    public void backTrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backTrack(nums, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Top_046 top_046 = new Top_046();
        List<List<Integer>> res = top_046.permute(new int[]{1, 2, 3});
        System.out.println(res);
    }
}
