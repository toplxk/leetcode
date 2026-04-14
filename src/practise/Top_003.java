package practise;

import java.util.HashSet;
import java.util.Map;

/**
 * @author lixiaokai1
 * @description
 * @date 2026/4/12 10:54
 */
public class Top_003 {
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int before = 0, after = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            while(set.contains(s.charAt(after))){
                set.remove(s.charAt(before++));
            }
            set.add(s.charAt(after));
            max = Math.max(max,after-before+1);
            after++;
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int res = lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
