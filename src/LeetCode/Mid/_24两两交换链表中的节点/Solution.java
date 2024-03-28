package LeetCode.Mid._24两两交换链表中的节点;

import DataStructure.ListNode;

/**
 * ClassName: Solution
 * Description: 两两交换链表中的节点
 * Author Inamikanju
 * Create 2023/11/5 19:33
 * Version 1.0
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode ahead = new ListNode(-1,head);
        ListNode cur=ahead;
        ListNode temp;
        ListNode first;
        ListNode second;

        while(cur.next!=null&&cur.next.next!=null){
            temp=cur.next.next.next;
            first=cur.next;
            second=cur.next.next;

            cur.next=second;
            second.next=first;
            first.next=temp;

            cur=first;
        }
        return ahead.next;
    }
}
