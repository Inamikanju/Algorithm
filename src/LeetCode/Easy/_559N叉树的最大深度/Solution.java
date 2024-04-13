package LeetCode.Easy._559N叉树的最大深度;

import java.util.List;

/**
 * ClassName: Solution
 * Description: N 叉树的最大深度
 * Author Inamikanju
 * Create 2024/4/10 15:50
 * Version 1.0
 */
public class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        List<Node> children = root.children;
        int max = 0;
        if (children != null) {
            //后续遍历
            for (Node node : children) {
                max = Math.max(max, maxDepth(node));
            }
            max = max + 1;
        }
        return max;
    }
}
