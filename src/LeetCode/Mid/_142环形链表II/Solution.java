package LeetCode.Mid._142环形链表II;

import DataStructure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Solution
 * Description: 环形链表 II
 * Author Inamikanju
 * Create 2023/11/7 14:39
 * Version 1.0
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> listNodes=new HashSet<>();
        ListNode cur=head;
        while(cur!=null){
            listNodes.add(cur);
            cur=cur.next;
            if(listNodes.contains(cur)){
                return cur;
            }
        }
        return null;
    }
}
