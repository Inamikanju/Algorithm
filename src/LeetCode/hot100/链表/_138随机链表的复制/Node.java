package LeetCode.hot100.链表._138随机链表的复制;

/**
 * ClassName: Node
 * Description:
 * Author Inamikanju
 * Create 2024/3/2 18:06
 * Version 1.0
 */
public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
