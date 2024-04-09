package LeetCode.Mid;

import DataStructure.ListNode;
import LeetCode.Mid._912排序数组.Solution;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

public class MidTest {
    @Test
    public void test1() {
        int target = 1122444449;

        int[] nums = {5, 2, 3, 1};
        int[] nums1 = {11, 81, 94, 43, 3};

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};

        String s = "ssx";
        String t = "uau";

        String[] words = {"a", "aa", "aaa", "aaaa"};
        ListNode head = CreateSList(nums);
//        System.out.println(ListToString(head));

        Solution solution = new Solution();
        long start = System.currentTimeMillis();
        var ans = solution.sortArray(nums);
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + "ms");

//        System.out.println(ListToString(ans));
        System.out.println(Arrays.toString(ans));
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
        String str = "[";
        if (head != null) {
            while (head != null) {
                str = str + head.val + ",";
                head = head.next;
            }
            str = str.substring(0, str.length() - 1);
        }
        str += "]";
        return str;
    }

}
