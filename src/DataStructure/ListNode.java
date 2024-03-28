package DataStructure;

import java.util.Arrays;

/**
 * ClassName: ListNode
 * Description:
 * Author Inamikanju
 * Create 2023/11/4 17:48
 * Version 1.0
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
