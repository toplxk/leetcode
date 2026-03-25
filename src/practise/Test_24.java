package practise;

import basic.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * @author lixiaokai1
 * @description
 * @date 2024/7/4 14:55
 */
public class Test_24 {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.build(Arrays.asList(1,2,3,4));
        ListNode res = swapPairs(head);
        System.out.println(res);
    }
}
