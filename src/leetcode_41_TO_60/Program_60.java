package leetcode_41_TO_60;

import java.util.ArrayList;
import java.util.List;

public class Program_60 {//顺序排列序列 Permutation SequenceInput: n = 3, k = 3    Output: "213"
    public static void main(String []args){
        Solution solution=new Solution();
        System.out.println(solution.getPermutation(9,24479));
    }

    static class Solution {
        public String getPermutation2(int n, int k) {
            StringBuilder sb = new StringBuilder();
            ArrayList<Integer> num = new ArrayList<Integer>();
            int fact = 1;
            for (int i = 1; i <= n; i++) {
                fact *= i;
                num.add(i);
            }
            for (int i = 0, l = k - 1; i < n; i++) {
                fact /= (n - i);
                int index = (l / fact);
                sb.append(num.remove(index));
                l -= index * fact;
            }
            return sb.toString();
        }


        public String getPermutation(int n, int k) {
            List<String>list=new ArrayList<>();
            String p[]=makeP(n);
            List<List<String>> lists=new ArrayList<>();
            backTrack(lists,list,p);
            StringBuilder sb=new StringBuilder();
            list=lists.get(k-1);
            for (int i=0;i<list.size();i++){
                sb.append(list.get(i));
            }
            return sb.toString();
        }

        void backTrack( List<List<String>> lists,List<String> list,String []nums){
            if (list.size()==nums.length) {
                lists.add(new ArrayList<>(list));
                return;
            }else{
                for (int i=0;i<nums.length;i++){
                    if (list.contains(nums[i]))continue;
                    //System.out.println(nums[i]);
                    list.add(nums[i]);
                    backTrack(lists,list,nums);
                    list.remove(list.size()-1);
                }
            }
           /* for (int i=start;i<nums.length;i++){
                list.add(nums[i]);
                backTrack(lists,list,nums,i+1);
                list.remove(list.size()-1);

            }*/

        }

       /* private void backTrace(List<String>list,int start,int k,String []p){
            //if (k==0)return;
        *//*    if (list.size()==p.length){
                k--;return;
            }*//*
            for (int i=0;i<p.length;i++){
                if (list.contains(p[i]))continue;
                list.add(p[i]);
                backTrace(list, start, k, p);

               *//* if (!list.contains(p[i])){
                  list.add(p[i]);
                  backTrace(list,i+1,k,p);
                }else { list.remove(list.size()-1);
                    System.out.println(p[i]);
                }*//*

               *//* if (list.contains(p[i]))
                   *//*

            }
        }
*/
        private String [] makeP(int n){
            String []p=new String[n];
            for (int i=0;i<n;i++){
                p[i]=(i+1)+"";
            }
            return p;
        }
    }
    //超出时间限制
}
