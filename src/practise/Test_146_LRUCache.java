package practise;

import java.util.HashMap;

/**
 * @author lixiaokai1
 * @description
 * @date 2026/3/25 10:46
 */
public class Test_146_LRUCache {

    static class DLinkedNode {
        public int key;
        public int value;
        public DLinkedNode prev;
        public DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private DLinkedNode head, tail;
    private int size = 0;
    private int capacity;
    private HashMap<Integer, DLinkedNode> cache = new HashMap<>();


    public Test_146_LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            node.value = value;     //修改值
            moveToHead(node);       //移动到头部
        } else {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);        //添加到头部
            size ++;
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        }

    }

    private DLinkedNode removeTail() {
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    public static void main(String[] args) {
        Test_146_LRUCache lruCache = new Test_146_LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        int result = lruCache.get(1);
        System.out.println(result);
        System.out.println("----------");
    }

}
