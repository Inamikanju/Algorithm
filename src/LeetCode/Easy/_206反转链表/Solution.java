package LeetCode.Easy._206反转链表;

import DataStructure.ListNode;

/**
 * ClassName: Solution
 * Description: 反转链表
 * Author Inamikanju
 * Create 2023/11/4 19:27
 * Version 1.0
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode temp = null;
        ListNode pre = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
