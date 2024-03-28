package LeetCode.hot100.链表._19删除链表的倒数第N个结点;

import DataStructure.ListNode;

/**
 * ClassName: Solution
 * Description: 删除链表的倒数第 N 个结点
 * Author Inamikanju
 * Create 2024/3/2 17:15
 * Version 1.0
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pHead = new ListNode(0, head);
        ListNode left = pHead;
        ListNode right = pHead;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return pHead.next;
    }
}
