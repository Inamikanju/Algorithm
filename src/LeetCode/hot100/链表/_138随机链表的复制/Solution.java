package LeetCode.hot100.链表._138随机链表的复制;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Solution
 * Description: 随机链表的复制
 * Author Inamikanju
 * Create 2024/3/2 18:06
 * Version 1.0
 */
public class Solution {
    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!map.containsKey(head)) {
            Node newNode = new Node(head.val);
            map.put(head, newNode);
            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);
        }
        return map.get(head);
    }
}
