package LeetCode.Hard;

import DataStructure.ListNode;
import LeetCode.Hard._689三个无重叠子数组的最大和.Solution;
import org.junit.Test;

import java.util.Arrays;

public class HardTest {
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

    @Test
    public void test1() {
        int target = 15;

        int[] nums = {3, 11, 2, 4};
        int[] nums1 = {11, 81, 43, 3};

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};

        String s = "and I quote: &quot;...&quot;";
        String t = "cae";

        String[] words = {"a", "aa", "aaa", "aaaa"};

        ListNode head = CreateSList(nums);
//        System.out.println(ListToString(head));

        Solution solution = new Solution();
        var ans = solution.maxSumOfOneSubarray(nums, target);

//        System.out.println(ListToString(ans));
//         System.out.println(ans);
//        System.out.println(Arrays.deepToString(ans));
        System.out.println(Arrays.toString(ans));
//        System.out.println(ans.toString());
    }

}