package LeetCode.hot100;

import DataStructure.ListNode;
import LeetCode.hot100.链表._146LRU缓存.LRUCache;
import LeetCode.hot100.回溯._79单词搜索.Solution;
import org.junit.Test;


public class Hot100Test {
    @Test
    public void testHot100() {
        int target = 3;

        int[] nums = {1, 1, 5};
        int[] nums1 = {11, 81, 94, 43, 3};

        int[][] matrix = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        char[][] board ={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";

        String s = "aaaaa";
        String t = "uau";

        String[] words = {"a", "aa", "aaa", "aaaa"};
        ListNode head = CreateSList(nums);
//        System.out.println(ListToString(head));


        Solution solution = new Solution();
        var ans = solution.exist(board,word);
//        System.out.println(ListToString(ans));
        System.out.println(ans);
    }

    public static ListNode CreateSList(int[] nums) {
        ListNode head = null;
        ListNode tail = null;
        int n = nums.length;
        for (int num : nums) {
            ListNode newNode = new ListNode();
            newNode.next = null;
            newNode.val = num;
            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    public String ListToString(ListNode head) {
        StringBuilder str = new StringBuilder("[");
        if (head != null) {
            while (head != null) {
                str.append(head.val).append(",");
                head = head.next;
            }
            str = new StringBuilder(str.substring(0, str.length() - 1));
        }
        str.append("]");
        return str.toString();
    }

    @Test
    public void testLRU() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
