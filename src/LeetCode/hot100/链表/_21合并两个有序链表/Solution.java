package LeetCode.hot100.链表._21合并两个有序链表;

import DataStructure.ListNode;

/**
 * ClassName: Solution
 * Description: 合并两个有序链表
 * Author Inamikanju
 * Create 2024/3/1 15:39
 * Version 1.0
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode cur = head;
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
        return head.next;
    }
}
