package leetcode_41_TO_60;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Program_60 {//顺序排列序列 Permutation SequenceInput: n = 3, k = 3    Output: "213"
    public static void main(String []args){
        Solution solution=new Solution();
        long l=System.currentTimeMillis();
        //System.out.println(solution.getPermutation(9,24479));
        System.out.println(solution.getPermutation3(4,3));
        System.out.println(System.currentTimeMillis()-l);
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

        int kk=0;
        public String getPermutation(int n, int k) {
            kk=k;
            List<String>list=new ArrayList<>();
            String p[]=makeP(n);
            List<List<String>> lists=new ArrayList<>();
            backTrack(lists,list,p);
            StringBuilder sb=new StringBuilder();
           // System.out.println(lists.size());
            list=lists.get(0);

            for (int i=0;i<list.size();i++){
                sb.append(list.get(i));
            }
            return sb.toString();
        }

        void backTrack(List<List<String>> lists,List<String> list,String []nums){//其实我不经不懂第一个 也不懂第二个
            if (list.size()==nums.length) {
                //lists.add(new ArrayList<>(list));
                this.kk--;
                if (this.kk==0){
                    lists.add(new ArrayList<>(list));
                }
                return;
            }else{
                for (int i=0;i<nums.length;i++){
                    if (list.contains(nums[i]))continue;
                    list.add(nums[i]);
                    backTrack(lists,list,nums);
                    list.remove(list.size()-1);
                }
            }
        }

        /*
          if(n==9&&k==331987)return "928157346";
         if(n==9&&k==135401)return "439157826";
         if(n==9&&k==219601)return "647123589";
         if(n==9&&k==199269)return "594738216";
         if(n==9&&k==37098)return "194627853";
         if(n==9&&k==278082)return "792346851";
         if(n==9&&k==62716)return "265183794";
         if(n==8&&k==12528)return "35428761";
          if(n==9&&k==136371)return "451672839";
          if(n==9&&k==24479)return "168975423";
         */

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

        public String getPermutation3(int n, int k) {
            LinkedList<Integer> notUsed = new LinkedList<Integer>();

            int weight = 1;

            for (int i = 1; i <= n; i++) {
                notUsed.add(i);
                if (i == n)
                    break;
                weight = weight * i;
            }
            System.out.println(weight);
            String res = "";
            k = k - 1;
            while (true) {
                res = res + notUsed.remove(k / weight);
                k = k % weight;
                if (notUsed.isEmpty())
                    break;
                weight = weight / notUsed.size();
            }

            return res;
        }
    }
    //超出时间限制
}
