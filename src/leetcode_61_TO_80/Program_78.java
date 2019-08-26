package leetcode_61_TO_80;

import java.util.ArrayList;
import java.util.List;

public class Program_78 {
    /*
    78. Subsets  集合 medium
    Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
     */




    public static void main(String []args){
        Solution solution=new Solution();
        System.out.print(solution.subsets(new int[]{1,2,3,4}));
    }

    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> lists=new ArrayList<>();
            List<Integer> list=new ArrayList<>();
            for (int i=0;i<=nums.length;i++)
                backTrace(lists,list,nums,0,i);
           // backTrace(lists,list,nums,0,nums.length);

            return lists;
        }
        void backTrace( List<List<Integer>> lists, List<Integer> list,int[] nums,int start,int k){
            if (list.size()==k){
                lists.add(new ArrayList<>(list));
                return;
            }

            for (int i=start;i<nums.length;i++){
                list.add(nums[i]);
                backTrace(lists,list,nums,i+1,k);
                if (list.size()>0)
                list.remove(list.size()-1);
            }
        }
    }
    /**
     * Runtime: 1 ms, faster than 42.82% of Java online submissions for Subsets.
     * Memory Usage: 36.4 MB, less than 99.18% of Java online submissions for Subsets.
     * 我傻了 题目的模板都是有的 这点难度难不倒我  只花了10分钟呢
     */
}
