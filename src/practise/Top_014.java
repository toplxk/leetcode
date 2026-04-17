package practise;

/**
 * @author lixiaokai1
 * @description
 * @date 2026/4/14 13:40
 */
public class Top_014 {

    public static String longestCommonPrefix(String[] strs) {
        String s = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while(!strs[i].startsWith(s)) {
                s = s.substring(0, s.length()-1);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"dog","racecar","car"};
        String res = longestCommonPrefix(strs);
        System.out.println(res);
    }
}
