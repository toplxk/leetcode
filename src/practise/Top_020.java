package practise;

import java.util.Stack;

/**
 * @author lixiaokai1
 * @description
 * @date 2026/4/16 15:25
 */
public class Top_020 {
    public static boolean isValid(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < ch.length; i++) {
            if (stack.isEmpty()) {
                stack.push(ch[i]);
            } else if (ch[i] == ')' && stack.peek() == '(' || ch[i] == ']' && stack.peek() == '[' || ch[i] == '}' && stack.peek() == '{') {
                stack.pop();
            } else {
                stack.push(ch[i]);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([)]";
        boolean res = isValid(s);
        System.out.println(res);
    }
}
