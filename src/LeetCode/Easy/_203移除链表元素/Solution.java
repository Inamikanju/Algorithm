package LeetCode.Easy._203移除链表元素;

import DataStructure.ListNode;

/**
 * ClassName: Solution
 * Description: 移除链表元素
 * Author Inamikanju
 * Create 2023/11/4 17:48
 * Version 1.0
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode ahead=new ListNode(-1,head);
        ListNode cur =head;
        ListNode pre =ahead;

        while(cur!=null){
            if(cur.val==val){
                pre.next=cur.next;
                cur=cur.next;
            }else {
                pre=pre.next;
                cur=cur.next;
            }
        }
        return ahead.next;
    }
}
