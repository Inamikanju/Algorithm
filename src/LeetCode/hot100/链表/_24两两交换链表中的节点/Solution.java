package LeetCode.hot100.链表._24两两交换链表中的节点;

import DataStructure.ListNode;

/**
 * ClassName: Solution
 * Description: 两两交换链表中的节点
 * Author Inamikanju
 * Create 2024/3/2 17:30
 * Version 1.0
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode pHead = new ListNode(-1, head);
        ListNode cur = pHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode left = cur.next;
            ListNode right = cur.next.next;
            cur.next = right;
            left.next = right.next;
            right.next = left;
            cur = left;
        }
        return pHead.next;
    }
}
