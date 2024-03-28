package LeetCode.hot100.链表._23合并K个升序链表;

import DataStructure.ListNode;

/**
 * ClassName: Solution
 * Description: 合并 K 个升序链表
 * Author Inamikanju
 * Create 2024/3/3 16:24
 * Version 1.0
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 顺序合并
//        ListNode ans = null;
//        for (ListNode list : lists) {
//            ans = mergeTwoLists(ans, list);
//        }
//        return ans;

        //分治合并
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
