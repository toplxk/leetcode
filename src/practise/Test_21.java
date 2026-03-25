package practise;

import basic.ListNode;

import java.util.Arrays;

/**
 * @author lixiaokai1
 * @description
 * @date 2024/5/16 15:33
 */

public class Test_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode temp = res;
        while (list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        while (list1 != null) {
            temp.next = list1;
            list1 = list1.next;
            temp = temp.next;
        }
        while (list2 != null) {
            temp.next = list2;
            list2 = list2.next;
            temp = temp.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode list1 = ListNode.build(Arrays.asList(1, 2, 4));
        ListNode list2 = ListNode.build(Arrays.asList(1, 3, 4));
        ListNode res = new Test_21().mergeTwoLists(list1, list2);
        System.out.println(res.toString());;
    }
}
