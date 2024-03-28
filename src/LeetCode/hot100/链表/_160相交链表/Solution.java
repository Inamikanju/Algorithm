package LeetCode.hot100.链表._160相交链表;

import DataStructure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Solution
 * Description: 相交链表
 * Author Inamikanju
 * Create 2024/2/29 21:30
 * Version 1.0
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = headA;
        while (cur != null) {
            set.add(cur);
            cur = cur.next;
        }
        cur = headB;
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
}
