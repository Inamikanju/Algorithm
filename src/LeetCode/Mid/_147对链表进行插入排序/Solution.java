package LeetCode.Mid._147对链表进行插入排序;

import DataStructure.ListNode;

/**
 * ClassName: Solution
 * Description: 对链表进行插入排序
 * Author Inamikanju
 * Create 2024/3/3 15:02
 * Version 1.0
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pHead = new ListNode(0, head);
        ListNode end = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (end.val <= cur.val) {
                end = cur;
            } else {
                ListNode pre = pHead;
                while (pre.next.val <= cur.val) {
                    pre = pre.next;
                }
                end.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = end.next;
        }
        return pHead.next;
    }
}
