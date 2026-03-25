package basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixiaokai1
 * @description
 * @date 2024/2/7 0:14
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public static ListNode build(List<Integer> list) {
        ListNode listNode = new ListNode(-1);
        ListNode p = listNode;
        for(Integer val : list) {
            p.next = new ListNode(val);
            p = p.next;
        }
        return listNode.next;
    }

    @Override
    public String toString() {
        List<Integer> res = new ArrayList<>();
        ListNode listNode = this;
        while(listNode != null) {
            res.add(listNode.val);
            listNode = listNode.next;
        }
        return res.toString();
    }
}
