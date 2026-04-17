package practise;

import basic.ListNode;

import java.util.Arrays;

/**
 * @author lixiaokai1
 * @description
 * @date 2026/4/17 14:03
 */
public class Top_021 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
        }
        while(list1 != null) {
            temp.next = list1;
            temp = temp.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            temp.next = list2;
            temp = temp.next;
            list2 = list2.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode l1 = ListNode.build(Arrays.asList(1, 2, 4));
        ListNode l2 = ListNode.build(Arrays.asList(1, 3, 4));
        ListNode res = mergeTwoLists(l1, l2);
        System.out.println(res);
    }
}
