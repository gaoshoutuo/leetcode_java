package leetcode_21_TO_40;

import java.util.*;

public class Program_40 {//不可重复使用组合目标

    /**
     * Runtime: 7 ms, faster than 35.97% of Java online submissions for Combination Sum II.
     * Memory Usage: 38.3 MB, less than 87.23% of Java online submissions for Combination Sum II.
     * Next challenges:
     * Insert Delete GetRandom O(1) - Duplicates allowed
     */

    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            Set<List<Integer>> lists=new HashSet<>();
            backTrack(candidates,0,target,lists,new ArrayList<>());
         /*   Set<List<Integer>> set=new HashSet<>(lists);
            List<List<Integer>>list2=new ArrayList<>(set);*/
            return new ArrayList<>(lists);
        }
        public void backTrack(int[] candidates,int start,int minus,Set<List<Integer>>lists,List<Integer>bList){
            if (minus==0){
                lists.add(new ArrayList<>(bList));
            }else if (minus>0){
                for(int i=start;i<candidates.length&&minus>=candidates[i];i++){
                    bList.add(candidates[i]);
                    backTrack(candidates,i+1,minus-candidates[i],lists,bList);
                    bList.remove(bList.size()-1);
                }
            }
        }
    }
}
