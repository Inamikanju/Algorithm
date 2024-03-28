package LeetCode.hot100.链表._141环形链表;

import DataStructure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Solution
 * Description: 环形链表
 * Author Inamikanju
 * Create 2024/3/1 15:27
 * Version 1.0
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
