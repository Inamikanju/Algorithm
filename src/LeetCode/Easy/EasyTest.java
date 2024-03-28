package LeetCode.Easy;

import DataStructure.ListNode;
import LeetCode.Easy._20有效的括号.Solution;
import org.junit.Test;

public class EasyTest {
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
        int target = 11;

        int[] nums = {3, 1, 2, 4};
        int[] nums1 = {11, 81, 94, 43, 3};

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};

        String s = "()";
        String t = "cae";

        String[] words = {"a", "aa", "aaa", "aaaa"};

        ListNode head = CreateSList(nums);
//        System.out.println(ListToString(head));

        Solution solution = new Solution();
        var ans = solution.isValid(s);

//        System.out.println(ListToString(ans));
        System.out.println(ans);
//        System.out.println(Arrays.deepToString(ans));
//        System.out.println(Arrays.toString(ans));
//        System.out.println(ans.toString());
    }

}