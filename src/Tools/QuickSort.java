package Tools;

import java.util.Arrays;

/**
 * ClassName: QuickSort
 * Description:
 * Author Inamikanju
 * Create 2023/11/14 11:51
 * Version 1.0
 */
public class QuickSort {
    public static void quickSort(int[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }
    }

    public static int partition(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i++;
                swap(A, i, j);
            }
        }
        swap(A, i + 1, r);
        return i + 1;
    }

    public static void swap(int[] A,int i,int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.print("排序前：");
        System.out.println(Arrays.toString(nums));
        quickSort(nums,0,nums.length-1);
        System.out.print("排序后：");
        System.out.println(Arrays.toString(nums));
    }
}
