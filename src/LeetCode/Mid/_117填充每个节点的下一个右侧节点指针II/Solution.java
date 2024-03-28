package LeetCode.Mid._117填充每个节点的下一个右侧节点指针II;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * ClassName: Solution
 * Description: 填充每个节点的下一个右侧节点指针 II
 * Author Inamikanju
 * Create 2023/11/3 15:41
 * Version 1.0
 */
public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node last = null;
            for (int i = 0; i < n; i++) {
                Node p = queue.poll();
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
                if (i != 0) {
                    last.next = p;
                }
                last = p;
            }
        }
        return root;
    }
}
