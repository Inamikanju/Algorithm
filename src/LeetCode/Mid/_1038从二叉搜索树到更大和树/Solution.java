package LeetCode.Mid._1038从二叉搜索树到更大和树;

import DataStructure.TreeNode;

/**
 * ClassName: Solution
 * Description: 从二叉搜索树到更大和树
 * Author Inamikanju
 * Create 2023/12/4 15:27
 * Version 1.0
 */
public class Solution {
    private int sum=0;

    public TreeNode bstToGst(TreeNode root) {
        order(root);
        return root;
    }

    private void order(TreeNode root){
        if(root!=null){
            order(root.right);
            root.val+=sum;
            sum=root.val;
            order(root.left);
        }
    }
}
