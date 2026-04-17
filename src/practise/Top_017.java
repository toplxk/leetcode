package practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lixiaokai1
 * @description
 * @date 2026/4/15 15:25
 */
public class Top_017 {
    public static List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }

        Map<Character, String> hashMap = new HashMap<Character, String>();
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");

        StringBuffer s = new StringBuffer();
        backTrack(res, digits, hashMap, 0, s);

        return res;
    }

    public static void backTrack(List<String> res, String digits, Map<Character, String> hashMap, int index, StringBuffer s) {
        if (index == digits.length()) {
            res.add(s.toString());
            return ;
        }
        char digit = digits.charAt(index);
        String curStr = hashMap.get(digit);
        for (int i = 0; i < curStr.length(); i++) {
            s.append(curStr.charAt(i));
            backTrack(res, digits, hashMap, index + 1, s);
            s.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> res = letterCombinations(digits);
        System.out.println(res);
    }
}
