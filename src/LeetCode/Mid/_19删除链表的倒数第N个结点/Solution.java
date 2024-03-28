package LeetCode.Mid._19删除链表的倒数第N个结点;

import DataStructure.ListNode;

/**
 * ClassName: Solution
 * Description: 删除链表的倒数第 N 个结点
 * Author Inamikanju
 * Create 2023/11/7 14:06
 * Version 1.0
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1,head);
        ListNode fast=dummy;
        ListNode slow=dummy;

        //fast首先走n+1步,slow才能指向删除节点的上一个节点
        for(int i=0;i<=n;i++){
            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
}
