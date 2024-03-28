package LeetCode.Easy._349两个数组的交集;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Solution
 * Description: 两个数组的交集
 * Author Inamikanju
 * Create 2023/11/11 15:12
 * Version 1.0
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null||nums1.length==0||nums2==null||nums2.length==0){
            return new int[0];
        }
        Set<Integer> set=new HashSet<>();
        Set<Integer> ansSet=new HashSet<>();
        for(int i:nums1){
            set.add(i);
        }
        for(int i:nums2){
            if(set.contains(i)){
                ansSet.add(i);
            }
        }
        return ansSet.stream().mapToInt(x->x).toArray();
    }
}
