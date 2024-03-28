package LeetCode.hot100.链表._234回文链表;

import DataStructure.ListNode;

/**
 * ClassName: Solution
 * Description: 回文链表
 * Author Inamikanju
 * Create 2024/3/1 15:01
 * Version 1.0
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        cur = head;
        ListNode pre = null;
        for (int i = 0; i < length / 2; i++) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        if (length % 2 != 0) {
            cur = cur.next;
        }
        while (pre != null && cur != null) {
            if (pre.val != cur.val) {
                return false;
            }
            pre = pre.next;
            cur = cur.next;
        }
        return true;
    }
}
