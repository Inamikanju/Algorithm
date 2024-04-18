package LeetCode.Hard._23合并K个升序链表;

import DataStructure.ListNode;

/**
 * ClassName: Solution
 * Description: 合并 K 个升序链表
 * Author Inamikanju
 * Create 2024/4/14 16:28
 * Version 1.0
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //分治合并
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        //递归出口
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        //先分后合
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return merge2(l1, l2);
    }

    private ListNode merge2(ListNode l1, ListNode l2) {
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
        cur.next = l1 != null ? l1 : l2;
        return list.next;
    }
}
