package leetcode_21_TO_40;

import java.lang.reflect.Array;
import java.util.*;

//可重复的加到目标值
public class Program_39 {
    /**
     * 1.数组转化为List：
     * String[] strArray= new String[]{"Tom", "Bob", "Jane"};
     *
     * List strList= Arrays.asList(strArray);
     *
     * 2.数组转Set
     * String[] strArray= new String[]{"Tom", "Bob", "Jane"};
     *
     * Set<String> staffsSet = new HashSet<>(Arrays.asList(staffs));
     *
     * staffsSet.add("Mary"); // ok
     *
     * staffsSet.remove("Tom"); // ok
     *
     * 3.List转Set
     * String[] staffs = new String[]{"Tom", "Bob", "Jane"};
     *
     * List staffsList = Arrays.asList(staffs);
     *
     * Set result = new HashSet(staffsList);
     *
     * 4.set转List
     * String[] staffs = new String[]{"Tom", "Bob", "Jane"};
     *
     * Set<String> staffsSet = new HashSet<>(Arrays.asList(staffs));
     *
     * List<String> result = new ArrayList<>(staffsSet);
     *
     *
     * Runtime: 2 ms, faster than 99.86% of Java online submissions for Combination Sum.
     * Memory Usage: 37.5 MB, less than 99.66% of Java online submissions for Combination Sum.
     * @param args
     */

    public static void main(String []args){

    }
    static class Solution {
        //两种解决办法 一种是暴力添加set  另一种回所
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<Integer>bList=new ArrayList<>();
            List<List<Integer>>lists=new ArrayList<List<Integer>>();
            backTrack(candidates,target,bList,lists,0);
            return lists;
        }

        public void backTrack(int[] cand,int minus,List<Integer>bList,List<List<Integer>>lists,int start){
           if (minus==0){
               lists.add(new ArrayList<>(bList));
           }else if (minus>0){
              for(int i=start;i<cand.length&&minus>=cand[i];i++){//这一步其实与我相同
                 bList.add(cand[i]);
                 backTrack(cand,minus-cand[i],bList,lists,i);
                 bList.remove(bList.size()-1);//会所的关键
              }

           }
           //bList.remove(bList.size()-1);
        }
    }
}
