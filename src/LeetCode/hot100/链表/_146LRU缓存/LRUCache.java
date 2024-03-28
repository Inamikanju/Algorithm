package LeetCode.hot100.链表._146LRU缓存;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LRUCache
 * Description: LRU 缓存
 * Author Inamikanju
 * Create 2024/3/3 16:42
 * Version 1.0
 */
public class LRUCache {

    static class DNode {
        int key;
        int value;
        DNode prev;
        DNode next;

        public DNode() {
        }

        public DNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DNode(int key, int value, DNode prev, DNode next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private final int capacity;
    private int size;
    private final Map<Integer, DNode> map = new HashMap<>();
    private final DNode head;
    private final DNode tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new DNode();
        this.tail = new DNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        int value = node.value;
        extractList(node);
        insertHead(node);
        return value;
    }

    public void put(int key, int value) {
        DNode node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            extractList(node);
            node.value = value;
        } else {
            node = new DNode(key, value);
            size++;
            if (size > capacity) {
                deleteTail();
            }
        }
        map.put(key, node);
        insertHead(node);
    }

    private void insertHead(DNode node) {
        DNode next = head.next;
        head.next = node;
        node.prev = head;
        next.prev = node;
        node.next = next;
    }

    private void extractList(DNode node) {
        DNode prev = node.prev;
        DNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void deleteTail() {
        DNode node = tail.prev;
        extractList(node);
        map.remove(node.key);
        size--;
    }
}
