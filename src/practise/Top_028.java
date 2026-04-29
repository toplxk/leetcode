package practise;

/**
 * @author lixiaokai1
 * @description
 * @date 2026/4/20 16:40
 */
public class Top_028 {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Top_028 top_028 = new Top_028();
        String haystack = "asdfssadbutsad";
        String needle = "sad";
        int res = top_028.strStr(haystack, needle);
        System.out.println(res);
    }
}
