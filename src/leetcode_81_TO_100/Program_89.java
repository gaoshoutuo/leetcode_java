package leetcode_81_TO_100;

import sun.nio.cs.ext.MacArabic;

import java.util.ArrayList;
import java.util.List;

public class Program_89 {
    /*
    89. Gray Code medium 无脑回溯真无耻
    Input: 2
Output: [0,1,3,2]
Explanation:
00 - 0
01 - 1
11 - 3
10 - 2

Input: 0
Output: [0]
     */
    public static void main(String []args){
        Solution solution=new Solution();

        List<Integer> list=solution.grayCode(0);
        for (Integer k:list){
            System.out.println(k);
        }
    }

    static class Solution {
        public List<Integer> grayCode(int n) {
            List<Integer>list=new ArrayList<>();
            if (n<0)return null;
            if (n==0){
                list.add(0);
                return list;
            }
            for (int i=0;i< Math.pow(2,n);i++){
                list.add(i^(i>>1));//这完全是按照定义来 之前想办法的回溯弄不出来
            }
            return list;
        }
    }
}
