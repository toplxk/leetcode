package practise;

import java.util.*;

import static practise.Top_020.isValid;

/**
 * @author lixiaokai1
 * @description
 * @date 2026/4/17 14:56
 */
public class Top_022 {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        backtrack(res, n, 0, 0, stringBuilder);
        return res;
    }

    /**
     *
     * @param res  合法的集合
     * @param n     单侧括号的数量
     * @param left  左侧括号的数量
     * @param right 右侧括号的数量
     * @param s     当前的括号串
     */
    private static void backtrack(List<String> res, int n, int left, int right, StringBuilder s) {
        if (left == n || right == n) {
            res.add(s.toString());
        }
        if (left < n) {
            s.append("(");
            backtrack(res, n, left + 1, right, s);
            s.deleteCharAt(s.length() - 1);
        }
        if (left < right) {
            s.append(")");
            backtrack(res, n, left, right + 1, s);
            s.deleteCharAt(s.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<String> res = generateParenthesis(n);
        System.out.println(res);
    }
}
