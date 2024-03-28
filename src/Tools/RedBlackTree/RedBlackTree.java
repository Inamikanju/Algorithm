package Tools.RedBlackTree;

/**
 * ClassName: RedBlackTree
 * Description:
 * Author Inamikanju
 * Create 2023/11/14 17:16
 * Version 1.0
 */
class Node {
    int data;
    Node parent;
    Node left;
    Node right;
    int color;
}

public class RedBlackTree {
    private static final int RED = 1;
    private static final int BLACK = 0;

    private Node root;
    private Node NIL;

    //构造器
    public RedBlackTree() {
        NIL = new Node();
        NIL.color = BLACK;
        NIL.left = null;
        NIL.right = null;
        root = NIL;
    }

    //左旋
    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != NIL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == NIL) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    //右旋
    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != NIL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == NIL) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.right = x;
        x.parent = y;
    }

    //插入
    public void insert(int key) {
        Node z = new Node();
        z.data = key;

        Node y = NIL;
        Node x = this.root;

        //从根节点开始向下搜索，找到插入位置
        while (x != NIL) {
            y = x;
            if (z.data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        //将新节点插入树中
        z.parent = y;
        if (y == NIL) {
            this.root = z;
        } else if (z.data < y.data) {
            y.left = z;
        } else {
            y.right = z;
        }
        z.left = NIL;
        z.right = NIL;
        z.color = RED;

        fixInsert(z);
    }

    //修复插入
    private void fixInsert(Node z) {
        Node y;
        while (z.parent.color == RED) {
            if (z.parent == z.parent.parent.left) {
                y = z.parent.parent.right;
                //叔结点红色
                if (y.color == RED) {
                    y.color = BLACK;
                    z.parent.color = BLACK;
                    z.parent.parent.color = RED;
                    z = z.parent.parent;
                }
                //叔结点黑色，z是右孩子
                else {
                    if (z == z.parent.right) {
                        z = z.parent;
                        leftRotate(z);
                    }
                    //叔结点黑色，z是左孩子
                    z.parent.color = BLACK;
                    z.parent.parent.color = RED;
                    rightRotate(z.parent.parent);
                }
            } else {
                y = z.parent.parent.left;
                if (y.color == RED) {
                    y.color = BLACK;
                    z.parent.color = BLACK;
                    z.parent.parent.color = RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        rightRotate(z);
                    }
                    z.parent.color = BLACK;
                    z.parent.parent.color = RED;
                    leftRotate(z.parent.parent);
                }
            }
        }
        root.color = BLACK;
    }

    //用新子树替换原子树
    private void transplant(Node u, Node v) {
        if (u.parent == NIL) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

    //根据键值搜索结点
    private Node search(int key) {
        return search(this.root, key);
    }
    private Node search(Node root, int key) {
        if (root == NIL || key == root.data) {
            return root;
        }
        if (key < root.data) {
            return search(root.left, key);
        }
        return search(root.right, key);
    }

    //寻找后继结点
    private Node findSuccessor(Node x) {
        while (x.left != NIL) {
            x = x.left;
        }
        return x;
    }

    //删除
    public void delete(int key) {
        Node z = search(key);
        if (z != NIL) {
            delete(z);
        }
    }
    private void delete(Node z) {
        Node y = z;
        Node x;
        int yOriginalColor = y.color;

        if (z.left == NIL) {
            x = z.right;
            transplant(z, z.right);
        } else if (z.right == NIL) {
            x = z.left;
            transplant(z, z.left);
        } else {
            y = findSuccessor(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == z) {
                x.parent = y;
            } else {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (yOriginalColor == BLACK) {
            fixDelete(x);
        }
    }

    //修复删除
    private void fixDelete(Node x) {
        Node w;
        while (x != root && x.color == BLACK) {
            if (x == x.parent.left) {
                w = x.parent.right;
                if (w.color == RED) {
                    w.color = BLACK;
                    x.parent.color = RED;
                    leftRotate(x.parent);
                    w = x.parent.right;
                }
                if (w.left.color == BLACK && w.right.color == BLACK) {
                    w.color = RED;
                    x = x.parent;
                } else {
                    if (w.right.color == BLACK) {
                        w.left.color = BLACK;
                        w.color = RED;
                        rightRotate(w);
                        w = x.parent.right;
                    }
                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    w.right.color = BLACK;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                w = x.parent.left;
                if (w.color == RED) {
                    w.color = BLACK;
                    x.parent.color = RED;
                    rightRotate(x.parent);
                    w = x.parent.left;
                }
                if (w.left.color == BLACK && w.right.color == BLACK) {
                    w.color = RED;
                    x = x.parent;
                } else {
                    if (w.left.color == BLACK) {
                        w.right.color = BLACK;
                        w.color = RED;
                        leftRotate(w);
                        w = x.parent.left;
                    }
                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    w.left.color = BLACK;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = BLACK;
    }

    //中序遍历
    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node root) {
        if (root != NIL) {
            inOrder(root.left);
            if (root.color == BLACK) {
                System.out.println("(BLACK, " + root.data + ")");
            } else {
                System.out.println("(RED, " + root.data + ")");
            }
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        RedBlackTree rb=new RedBlackTree();
        rb.insert(1);
        rb.insert(5);
        rb.insert(6);
        rb.insert(7);
        rb.insert(8);
        rb.insert(9);
        rb.insert(10);
        rb.insert(11);
        rb.insert(12);
        rb.insert(13);
        rb.insert(14);
        rb.insert(15);
        rb.inOrder();
        rb.delete(14);
        rb.delete(9);
        rb.delete(5);
        rb.inOrder();
    }
}
