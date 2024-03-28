package LeetCode.hot100.链表._148排序链表;

import DataStructure.ListNode;

/**
 * ClassName: Solution
 * Description: 排序链表
 * Author Inamikanju
 * Create 2024/3/3 15:01
 * Version 1.0
 */
public class Solution {
    public ListNode sortList(ListNode head) {
//        return sortList(head, null); // 自顶向下递归

        // 自底向上
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode pHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength *= 2) {
            ListNode pre = pHead;
            ListNode cur = pHead.next;
            while (cur != null) {
                ListNode list1 = cur;
                for (int i = 1; i < subLength && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode list2 = cur.next;
                cur.next = null;
                cur = list2;
                for (int i = 1; i < subLength && cur != null; i++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }
                ListNode sorted = merge(list1, list2);
                pre.next = sorted;
                while (pre.next != null) {
                    pre = pre.next;
                }
                cur = next;
            }
        }
        return pHead.next;
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode left = head;
        ListNode right = head;
        while (right != tail) {
            left = left.next;
            right = right.next;
            if (right != tail) {
                right = right.next;
            }
        }
        ListNode mid = left;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode pHead = new ListNode(0);
        ListNode cur = pHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 == null) {
            cur.next = list2;
        } else {
            cur.next = list1;
        }
        return pHead.next;
    }
}
