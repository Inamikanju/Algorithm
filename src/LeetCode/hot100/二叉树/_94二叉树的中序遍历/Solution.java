package LeetCode.hot100.二叉树._94二叉树的中序遍历;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: Solution
 * Description: 二叉树的中序遍历
 * Author Inamikanju
 * Create 2024/3/2 18:22
 * Version 1.0
 */
public class Solution {
    //    public List<Integer> inorderTraversal(TreeNode root) { //递归
//        List<Integer> ans = new ArrayList<>();
//        inorder(root, ans);
//        return ans;
//    }
//
//    private void inorder(TreeNode root, List<Integer> ans) {
//        if (root == null) {
//            return;
//        }
//        inorder(root.left, ans);
//        ans.add(root.val);
//        inorder(root.right, ans);
//    }
    private final int WHITE = 0;
    private final int GRAY = 1;

    class Node {
        int color;
        TreeNode treeNode;

        public Node(int color, TreeNode node) {
            this.color = color;
            this.treeNode = node;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) { //迭代
        List<Integer> ans = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        stack.push(new Node(WHITE, root));
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            int color = cur.color;
            TreeNode node = cur.treeNode;
            if (node == null) {
                continue;
            }
            if (color == WHITE) {
                stack.push(new Node(WHITE, node.right));
                stack.push(new Node(GRAY, node));
                stack.push(new Node(WHITE, node.left));
            } else {
                ans.add(node.val);
            }
        }
        return ans;
    }
}
