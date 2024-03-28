package LeetCode.Mid._2415反转二叉树的奇数层;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: Solution
 * Description: 反转二叉树的奇数层
 * Author Inamikanju
 * Create 2023/12/15 14:46
 * Version 1.0
 */
public class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean isOdd = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (isOdd) {
                    list.add(node);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if (isOdd) {
                for (int i = 0, j = size - 1; i < j; i++, j--) {
                    int temp = list.get(i).val;
                    list.get(i).val = list.get(j).val;
                    list.get(j).val = temp;
                }
            }
            isOdd = !isOdd;
        }
        return root;
    }
}
