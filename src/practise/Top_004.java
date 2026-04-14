package practise;

/**
 * @author lixiaokai1
 * @description
 * @date 2026/4/12 17:00
 */
public class Top_004 {
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {      //长度小于2时，s就是回文的
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {     //每个单独的字符都是回文
            dp[i][i] = true;
        }
        int maxLen = 1;
        int start = 0;
        char[] ch = s.toCharArray();
        for (int j = 1; j < len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (ch[i] != ch[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {   //i和j相邻或者隔一个字符就是回文
                        dp[i][j] = true;
                    } else {    //动态转移方程
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && maxLen <= j - i + 1) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String s = "abbcccba";
        String res = longestPalindrome(s);
        System.out.println(res);
    }


}
