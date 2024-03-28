package LeetCode.Easy._160相交链表;

import DataStructure.ListNode;

/**
 * ClassName: Solution
 * Description: 相交链表
 * Author Inamikanju
 * Create 2023/11/7 14:22
 * Version 1.0
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA=headA;
        ListNode curB=headB;
        int lenA=0;
        int lenB=0;
        while(curA!=null){
            lenA++;
            curA=curA.next;
        }
        while(curB!=null){
            lenB++;
            curB=curB.next;
        }
        curA=headA;
        curB=headB;

        if(lenB>lenA){
            int tmpLen=lenA;
            lenA=lenB;
            lenB=tmpLen;
            ListNode tmpNode=curA;
            curA=curB;
            curB=tmpNode;
        }

        int d=lenA-lenB;
        for(int i=0;i<d;i++){
            curA=curA.next;
        }

        while(curA!=null){
            if(curA==curB){
                return curA;
            }
            curA=curA.next;
            curB=curB.next;
        }
        return null;
    }
}