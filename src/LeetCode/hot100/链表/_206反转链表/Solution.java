package LeetCode.hot100.链表._206反转链表;

import DataStructure.ListNode;

/**
 * ClassName: Solution
 * Description: 反转链表
 * Author Inamikanju
 * Create 2024/2/29 21:40
 * Version 1.0
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
