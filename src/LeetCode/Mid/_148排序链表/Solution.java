package LeetCode.Mid._148排序链表;

import DataStructure.ListNode;

/**
 * ClassName: Solution
 * Description: 排序链表
 * Author Inamikanju
 * Create 2024/4/14 16:20
 * Version 1.0
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        // 递归出口
        if (head == null || head.next == null) {
            return head;
        }
        // 重要！返回的是合并后的有序链表！
        // 先分后合
        ListNode mid = partition(head);// 定位中点
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(mid);
        return merge(l1, l2);
    }

    private ListNode partition(ListNode head) {
        ListNode pHead = new ListNode(0, head);
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;
        slow.next = null;
        return cur;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode list = new ListNode();
        ListNode cur = list;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return list.next;
    }
}
