package LeetCode.hot100.链表._142环形链表II;

import DataStructure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Solution
 * Description: 环形链表 II
 * Author Inamikanju
 * Create 2024/3/1 15:35
 * Version 1.0
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
