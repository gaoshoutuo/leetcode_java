package leetcode_61_TO_80;

public class Program_80 {
    /*
    给定排序的数组nums，就地删除重复项，使重复项最多出现两次并返回新的长度。  o1
    80. Remove Duplicates from Sorted Array II  medium
    Given nums = [1,1,1,2,2,3], 5
    Given nums = [0,0,1,1,1,1,2,3,3], 7
     */

    /**
     * 解题思路很简单
     * 就是对数组过一遍 要是值很小就可以用数组 值很大 就只能傻乎乎迁移
     */
    public static void main(String []args){
        Solution solution=new Solution();
        int []y=new int[]{1,1,1,2,2,3};
        int q=solution.removeDuplicates2(y);
        for (int i=0;i<q;i++){
            System.out.print(y[i]+"-");
        }
    }
    static class Solution {
        /**
         * Runtime: 1 ms, faster than 16.11% of Java online submissions for Remove Duplicates from Sorted Array II.
         * Memory Usage: 41.6 MB, less than 5.26% of Java online submissions for Remove Duplicates from Sorted Array II.
         * 数组拖累我的内存
         */
        int temp[]=new int[100];
        public int removeDuplicates(int[] nums) {
            if (nums.length==0)return 0;
            if (nums.length==1)return 1;
            int p1=1,p2=0;
            for (int i=1;i<nums.length-p2;i++){
                if (nums[i]==nums[i-1]){
                    if (temp[p1]<1){//第一次相等
                        temp[p1]++;
                    }else if (temp[p1]==1){//第二次相等
                        cleanOne(nums,i,p2);
                        p2++;
                        i--;
                    }
                }else {
                    p1++;
                }
            }
            return nums.length-p2;
        }

        /**
         * Runtime: 1 ms, faster than 16.11% of Java online submissions for Remove Duplicates from Sorted Array II.
         * Memory Usage: 41.7 MB, less than 5.26% of Java online submissions for Remove Duplicates from Sorted Array II.
         * 并没有提示 应该是删除数字的问题
         * @param nums
         * @return
         */

        public int removeDuplicates2(int[] nums) {
            if (nums.length==0)return 0;
            if (nums.length==1)return 1;
            int p2=0,num=0;
            for (int i=1;i<nums.length-p2;i++){
                if (nums[i]==nums[i-1]){
                    if (num<1){//第一次相等
                        num++;
                    }else if (num==1){//第二次相等
                        cleanOne(nums,i,p2);
                        p2++;
                        i--;
                    }
                }else{
                    num=0;
                }
            }
            return nums.length-p2;
        }
        void cleanOne(int []nums,int k,int p2){
            for (int i=k;i<nums.length-1-p2;i++){
                nums[i]=nums[i+1];
            }
        }
    }
}
