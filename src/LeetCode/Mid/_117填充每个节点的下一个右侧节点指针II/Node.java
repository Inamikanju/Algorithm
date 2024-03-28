package LeetCode.Mid._117填充每个节点的下一个右侧节点指针II;

/**
 * ClassName: Node
 * Description:
 * Author Inamikanju
 * Create 2023/11/3 15:39
 * Version 1.0
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
