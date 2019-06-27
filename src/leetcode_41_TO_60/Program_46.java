package leetcode_41_TO_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program_46 {//排列1 给出不重复数组 输出所有排列数组 4647 抄的 我根本不会

    public static void main(String []args){
        Solution solution=new Solution();
        Solution2 solution2=new Solution2();
        System.out.println(solution2.permute(new int[]{1,2,3,4}));
        System.out.println(solution2.permute(new int[]{1,2,3,4}).size());
       // System.out.println(solution.permute(new int[]{1,2,3,4,5}));
       // System.out.println(solution.permute(new int[]{1,2,3,4,5}).size());
    }

    static class Solution {//双指针
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> lists=new ArrayList<>();
            if (nums==null)return null;
            if (nums.length==1){
                addList(nums,lists);
                return lists;
            }
            if (nums.length==2){
                addList(nums,lists);
                swap(nums,0,1);
                addList(nums,lists);
                return lists;
            }

            for(int i=0;i<nums.length;i++){
                int[] ncopy=nums.clone();
                swap(ncopy,0,i);
                addList(ncopy,lists);
                twoPoint(lists,ncopy,1,2);
            }
            return lists;
        }

        void twoPoint( List<List<Integer>> lists,int[] nums,int p,int k){
           // System.out.println(p+""+k);
            int[] numcopy=nums.clone();
            if (p < nums.length - 1&&p<k) {
                swap(numcopy,p,k);
                addList(numcopy,lists);
                k++;

            }
            if (k>p+1&&k>=nums.length-1){
                p++;
            }else if (k==p+1&&k>=nums.length-1){
                return;
            }
            twoPoint(lists,nums,p,k);
        }

        private void swap(int[] A, int i, int j){
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }

        private void addList(int[] nums, List<List<Integer>> lists){
            List<Integer>list=new ArrayList<>();
            for (int i=0;i<nums.length;i++){
                list.add(nums[i]);
            }
            lists.add(list);
        }
    }

    static class Solution2 {//leetcode的模板使用方法 backtrack

        /*
        Runtime: 1 ms, faster than 99.25% of Java online submissions for Permutations.
Memory Usage: 37.6 MB, less than 93.74% of Java online submissions for Permutations.
         */

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> lists=new ArrayList<>();
            List<Integer>list=new ArrayList<>();
            backTrack(lists,list,nums);
            return lists;
        }

        void backTrack( List<List<Integer>> lists,List<Integer> list,int []nums){
            //List<Integer> list2=new ArrayList<>();
           // System.out.println(list);
            if (list.size()==nums.length) {
                lists.add(new ArrayList<>(list));
                return;
            }else{
                for (int i=0;i<nums.length;i++){
                    if (list.contains(nums[i]))continue;
                    list.add(nums[i]);
                    backTrack(lists,list,nums);
                    list.remove(list.size()-1);
                    //System.out.println(list+"---"+i);
                }
            }
           /* for (int i=start;i<nums.length;i++){
                list.add(nums[i]);
                backTrack(lists,list,nums,i+1);
                list.remove(list.size()-1);

            }*/

        }
    }
}
