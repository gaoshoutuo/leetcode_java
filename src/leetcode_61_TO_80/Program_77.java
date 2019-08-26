package leetcode_61_TO_80;

import java.util.ArrayList;
import java.util.List;

public class Program_77 {
    /*
    77. Combinations medium
    Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
    Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]  在谷歌工程师面前 大佬面前谦虚
     */

    public static void main(String []args){
        Solution solution=new Solution();
        System.out.print(solution.combine(4,2));
    }

    static class Solution {// 估计也是回溯法吧
        public List<List<Integer>> combine(int n, int k) {
            int []abc=new int[n];
            for (int i=0;i<n;i++){
                abc[i]=i+1;
            }

            List<List<Integer>> lists=new ArrayList<>();
            List<Integer> list=new ArrayList<>();
            backtrace(lists,list,k,abc,0);
            return lists;
        }
        void backtrace(List<List<Integer>> lists,List<Integer>list,int k,int []abc,int start) {
            if (list.size()==k){
                //System.out.print(list.get(0)+"--"+list.get(1));
                lists.add(new ArrayList<>(list));
                return;
            }
            //System.out.print(start);
            for (int i=start;i<abc.length;i++){//不应该呀 为什么呢 22 32 都出现了
                //System.out.println(abc[i]);
                list.add(abc[i]);
                backtrace(lists,list,k,abc,i+1);//不能始终start+1
                list.remove(list.size()-1);
            }
        }
        /**
         * Runtime: 26 ms, faster than 54.70% of Java online submissions for Combinations.
         * Memory Usage: 41.6 MB, less than 15.22% of Java online submissions for Combinations.
         */
    }
}