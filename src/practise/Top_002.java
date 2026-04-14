package practise;

import basic.ListNode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author lixiaokai1
 * @description
 * @date 2026/4/12 9:18
 */
public class Top_002 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            int one = sum % 10;
            ListNode node = new ListNode(one);
            cur.next = node;
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.build(Arrays.asList(9,9,9,9,9,9));
        ListNode l2 = ListNode.build(Arrays.asList(9,9,9,9));
        ListNode res = addTwoNumbers(l1, l2);
        System.out.println(res);
    }
}
