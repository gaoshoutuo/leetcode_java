package leetcode_61_TO_80;

public class Program_75 {
    /*
    75. Sort Colors medium
    Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
一个相当直接的解决方案是使用计数排序的两遍算法。
首先，迭代0,1，和2的数组计数，然后覆盖总数为0的数组，然后是1，然后是2。
但是要求只用一个空间 自己排序
Could you come up with a one-pass algorithm using only constant space?  只用一遍排序
     */
    public static void main(String []args){
        Solution solution=new Solution();
        solution.sortColors(new int[]{0,1,2,1,0,1});
    }

    //以后这种one pass 问题一律想到双针法  我傻了  这个办法不是我想出来的 但是我要吃透 小学生听懂
    static class Solution {
        public void sortColors(int[] nums) {
            int p=0,q=nums.length-1,index=0;
            while (index<=q){
                if (nums[index]==0){
                    swap(nums,index,p);
                    p++;
                }

                if (nums[index]==2){
                    swap(nums,index,q);
                    q--;
                    index--;
                }
                index++;
            }
/**

 Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
 Memory Usage: 35.1 MB, less than 99.21% of Java online submissions for Sort Colors.
 我傻了 真的牛逼 想出这个办法的
 */
          /*  for (int i=0;i<nums.length;i++){
                System.out.print(nums[i]+"-");
            }*/
        }
        void swap(int []num,int a,int b){
            int temp=num[a];
            num[a]=num[b];
            num[b]=temp;
        }
    }
}
