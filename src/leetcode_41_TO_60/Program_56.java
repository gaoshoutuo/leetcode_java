package leetcode_41_TO_60;

import java.util.*;

public class Program_56 {//Merge Intervals 并合并 Input: [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]]

 static int n=0;
    public static void main(String []args){
        Solution solution=new Solution();
         int [][]a=solution.merge(new int[][]{{0,3},{2,4},{3,5}});
        for (int i=0;i<n;i++){
            System.out.println(a[i][0]+""+a[i][1]);
        }

    }

    static class Solution {
        public int[][] merge(int[][] intervals) {

            if(intervals.length<=1)return intervals;
            Arrays.sort(intervals,(i1,i2)->Integer.compare(i1[0],i2[0]));

            List<int []> list=new ArrayList<>();
            for(int i=1;i<intervals.length;i++){
                if (  intervals[i-1][1]>=intervals[i][0]){
                    if (intervals[i-1][1]>=intervals[i][1]){
                        intervals[i][0]=intervals[i-1][0];
                        intervals[i][1]=intervals[i-1][1];
                        if (!list.contains(intervals[i])&&i==intervals.length-1)
                        list.add(intervals[i]);
                    }else{
                        intervals[i][0]=intervals[i-1][0];
                        if (!list.contains(intervals[i])&&i==intervals.length-1)
                            list.add(intervals[i]);
                    }
                }else{
                    if (!list.contains(intervals[i-1])&&intervals[i-1]!=null)
                        list.add(intervals[i-1]);
                    if (!list.contains(intervals[i])&&i==intervals.length-1)
                        list.add(intervals[i]);
                   // System.out.println(intervals[i][0]+""+intervals[i][1]);
                    //if (intervals[i]==null)System.out.println(i);
                }
            }
            n=list.size();
            return list.toArray(new int[list.size()][]);
        }
    }

    /*
    Runtime: 37 ms, faster than 32.21% of Java online submissions for Merge Intervals.
Memory Usage: 39.2 MB, less than 93.76% of Java online submissions for Merge Intervals.
不得不说这是一个测试用例得出的结论 感觉怪怪的
     */
   /* class comp implements Comparable<int [][]>{

        @Override
        public int compareTo(int [][] o) {
            if (o[])
            return 0;
        }
    }*/
}
