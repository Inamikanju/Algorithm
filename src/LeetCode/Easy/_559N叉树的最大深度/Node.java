package LeetCode.Easy._559N叉树的最大深度;

import java.util.List;

/**
 * ClassName: Node
 * Description:
 * Author Inamikanju
 * Create 2024/4/10 16:14
 * Version 1.0
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
