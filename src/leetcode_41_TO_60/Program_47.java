package leetcode_41_TO_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program_47 {//给出重复包含的数组 给出所有的排列
    public static void main(String []args){
        Solution solution=new Solution();
        System.out.println(solution.permuteUnique(new int[]{3,3,0,3}));
    }


    static class Solution {//leetcode的模板使用方法 backtrack
        /*
        Runtime: 1 ms, faster than 100.00% of Java online submissions for Permutations II.
Memory Usage: 38.9 MB, less than 94.91% of Java online submissions for Permutations II.
         */

        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> lists=new ArrayList<>();
            List<Integer>list=new ArrayList<>();
            Arrays.sort(nums);
            backTrack(lists,list,nums,new boolean[nums.length]);
            return lists;
        }

        void backTrack( List<List<Integer>> lists,List<Integer> list,int []nums,boolean used[]){
            if (list.size()==nums.length) {
                lists.add(new ArrayList<>(list));
                return;
            }else {
                for (int i = 0; i < nums.length; i++) {
                    //System.out.println(i);
                    if ( i > 0 && nums[i] == nums[i - 1] && !used[i - 1]||used[i]) continue;//&& (逻辑与) 优先级高于||（逻辑或）
                    used[i] = true;
                    //System.out.println(nums[i]);
                    list.add(nums[i]);
                    backTrack(lists, list, nums, used);
                    used[i] = false;
                    list.remove(list.size() - 1);
                    //System.out.println(list + "---" + i);
                }
            }
        }
    }
}
