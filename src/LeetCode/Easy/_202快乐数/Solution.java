package LeetCode.Easy._202快乐数;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Solution
 * Description: 快乐数
 * Author Inamikanju
 * Create 2023/11/11 15:44
 * Version 1.0
 */
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        while(!set.contains(n)) {
            if(n==1){
                return true;
            }
            set.add(n);
            n = getNextNumber(n);
        }
        return false;
    }
    public int getNextNumber(int n){
        int sum=0;
        while(n>0){
            int p=n%10;
            sum+=p*p;
            n=n/10;
        }
        return sum;
    }
}
