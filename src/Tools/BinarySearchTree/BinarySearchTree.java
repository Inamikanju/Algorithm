package Tools.BinarySearchTree;

/**
 * ClassName: IsBinarySearchTree
 * Description:
 * Author Inamikanju
 * Create 2023/11/14 16:43
 * Version 1.0
 */
class Node {
    int value;
    Node left;
    Node right;
    Node(int value){
        this.value=value;
    }
}

public class BinarySearchTree {
    public static boolean isBinarySearchTree(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.value >= root.value) {
            return false;
        }
        if (root.right != null && root.right.value <= root.value) {
            return false;
        }
        return isBinarySearchTree(root.left) && isBinarySearchTree(root.right);
    }

    public static void main(String[] args) {
        Node node1=new Node(1);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        Node node6=new Node(6);
        node5.left=node1;
        node5.right=node4;
        node4.left=node3;
        node4.right=node6;
        boolean result=isBinarySearchTree(node5);
        System.out.println(result);
    }
}
