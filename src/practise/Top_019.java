package practise;

import basic.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lixiaokai1
 * @description
 * @date 2026/4/16 14:28
 */
public class Top_019 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = head;
        ListNode next = dummy;
        while (n > 0) {
            start = start.next;
            n--;
        }
        while(start != null) {
            next = next.next;
            start = start.next;
        }
        next.next = next.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        ListNode l = ListNode.build(list);
        int n = 2;
        ListNode res = removeNthFromEnd(l, n);
        System.out.println(res);
    }
}
