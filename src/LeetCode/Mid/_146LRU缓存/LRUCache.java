package LeetCode.Mid._146LRU缓存;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LRUCache
 * Description: LRU缓存
 * Author Inamikanju
 * Create 2024/4/14 16:46
 * Version 1.0
 */
public class LRUCache {
    // 当前大小，总容量，链表(双向)，哈希表(key,Node)
    int size = 0;
    final int capacity;
    Node head;
    Node tail;
    Map<Integer, Node> map;

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node() {
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        extract(node);
        insertFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            extract(node);
            insertFirst(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            insertFirst(node);
            size++;
            if (size > capacity) {
                deleteLast();
                size--;
            }
        }
    }

    private void extract(Node cur) {
        Node prev = cur.prev;
        Node next = cur.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insertFirst(Node cur) {
        Node oldFirst = head.next;
        head.next = cur;
        cur.next = oldFirst;
        oldFirst.prev = cur;
        cur.prev = head;
    }

    private void deleteLast() {
        Node last = tail.prev;
        extract(last);
        map.remove(last.key);
    }
}
