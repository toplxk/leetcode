package practise;

import basic.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * @author lixiaokai1
 * @description
 * @date 2026/3/25 0:29
 */
public class Test_92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(-1);      //虚拟头节点
        dummyHead.next = head;
        ListNode prev = dummyHead;
        for (int i = 0; i < left - 1; i++) {        //定位到需要翻转的位置
            prev = prev.next;
        }
        ListNode curr = prev.next;
        ListNode next;
        for (int i = left; i < right; i++) {
            next = curr.next;               //  找到下一个节点
            curr.next = next.next;          //当前节点指向下一个节点的下一节点
            next.next = prev.next;          //当前节点的下一节点指向前一节点的下一节点，实现翻转
            prev.next = next;               //前一节点指向当前节点的下一节点
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
//        int[] nums = {9,7,5,2,4,3,6};
        ListNode list = ListNode.build(Arrays.asList(9,7,5,2,4,3,6));
        int left = 3;
        int right = 6;
        ListNode res = new Test_92().reverseBetween(list, left, right);
        System.out.println(res.toString());
    }
}
