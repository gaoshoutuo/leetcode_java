package leetcode_81_TO_100;

import java.util.Arrays;

public class Program_88 {
    /*88. Merge Sorted Array easy
    Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
     */
    public static void main(String []args){
        Solution solution=new Solution();
        int []m1=new int[]{-1,0,0,3,3,3,0,0,0};
        int []m2=new int[]{1,2,2};
        solution.merge2(m1,6,m2,3);
    }

    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {

            if (nums1==null||nums2==null||nums1.length==0||nums2.length==0)return;
            if (m+n>nums1.length)return;
            for (int i=0,j=0;i<nums1.length||j<nums2.length;i++){
                if (i>nums2.length-1){
                    swap(nums1,nums2,i, j);
                    j++;
                    continue;
                }
                if (nums1[i]>nums2[j]){
                    swap(nums1,nums2,i, j);
                    Arrays.sort(nums2);
                }
            }
            for (int i=0;i<nums1.length;i++){
                System.out.println(nums1[i]);
            }
        }
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
        //Memory Usage: 39.8 MB, less than 5.94% of Java online submissions for Merge Sorted Array.

        public void merge2(int[] nums1, int m, int[] nums2, int n) {//虽然不是我写的 但是我看明白了 估计一时半会也想不到
            int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
            while (tail1 >= 0 && tail2 >= 0) {
                nums1[finished--] = (nums1[tail1] > nums2[tail2]) ?
                        nums1[tail1--] : nums2[tail2--];
            }

            while (tail2 >= 0) { //only need to combine with remaining nums2
                nums1[finished--] = nums2[tail2--];
            }
           /*     for (int i=0;i<nums1.length;i++){
                System.out.println(nums1[i]);
            }*/
        }
        public void swap(int []kk,int []ll,int i,int j){
            int temp=kk[i];
            kk[i]=ll[j];
            ll[j]=temp;
        }
    }
}
