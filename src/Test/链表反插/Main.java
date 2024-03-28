package Test.链表反插;

/**
 * ClassName: Main
 * Description: 1->2->3->4->5->6->7    1->7->2->6->3->5->4
 * Author Inamikanju
 * Create 2024/3/22 14:24
 * Version 1.0
 */
class Main {
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static Node createList(int n) {
        Node node = new Node(n);
        while (n > 1) {
            node = new Node(n - 1, node);
            n--;
        }
        return node;
    }

    public static Node reverse(Node list) {
        Node cur = list;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int skip = len / 2;

        cur = list;
        for (int i = 0; i < skip; i++) {
            cur = cur.next;
        }
        Node pre = cur;
        cur = cur.next;
        pre.next = null;

        pre = null;
        while (cur != null) {
            Node temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void merge(Node list1, Node list2) {
        Node cur1 = list1;
        Node cur2 = list2;
        while (cur1.next != null && cur2 != null) {
            Node temp1 = cur1.next;
            Node temp2 = cur2.next;
            cur1.next = cur2;
            cur2.next = temp1;
            cur1 = temp1;
            cur2 = temp2;
        }
    }

    public static void print(Node list) {
        StringBuilder stringBuilder = new StringBuilder();
        Node cur = list;
        while (cur != null) {
            stringBuilder.append(cur.val);
            if (cur.next != null) {
                stringBuilder.append("->");
            }
            cur = cur.next;
        }
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) {
        Node list = createList(7);
        print(list);
        Node list2 = reverse(list);
        print(list);
        print(list2);
        merge(list, list2);
        print(list);
    }
}
