package LeetCode.hot100.链表._25K个一组翻转链表;

import DataStructure.ListNode;

/**
 * ClassName: Solution
 * Description: K个一组翻转链表
 * Author Inamikanju
 * Create 2024/3/2 17:39
 * Version 1.0
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pHead = new ListNode(-1, head);
        ListNode cur = pHead;
        ListNode end = pHead;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;
            ListNode start = cur.next;
            ListNode next = end.next;
            end.next = null;
            cur.next = reverse(start);
            start.next = next;
            cur = start;
            end = cur;
        }
        return pHead.next;
    }

    private ListNode reverse(ListNode head) {
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
