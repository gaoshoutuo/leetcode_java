package leetcode_41_TO_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program_57 {// Hard Insert Interval 插入合并集合 Input: intervals = [[1,3],[6,9]], newInterval = [2,5]    Output: [[1,5],[6,9]]

// 失败的作品 不好

    public static void main(String []args){
        Solution solution=new Solution();
        int a[][]=solution.insert(new int[][]{{3,5},{12,15}},new int[]{6,6});
        for (int i=0;i<a.length;i++){
            System.out.println(a[i][0]+""+a[i][1]+"---");
        }
    }
    static class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> list=new ArrayList<>();
          /*  List<int[]> list=new ArrayList<>();//懂了 我试试
            if (intervals.length==0){
                list.add(newInterval);
                return list.toArray(new int[list.size()][]);
            }
            if (newInterval[1]<intervals[0][0]){
                list.add(newInterval);
                for (int i=0;i<intervals.length;i++){
                    list.add(intervals[i]);
                }
                return list.toArray(new int[list.size()][]);
            }

            Arrays.sort(intervals,(i1,i2)->Integer.compare(i1[0],i2[0]));
            int p=0,q=0;
            for (int i=0;i<intervals.length;i++){
                if (newInterval[0]<=intervals[i][0]){
                    intervals[i][0]=newInterval[0];
                    p=i;break;
                }else if (newInterval[0]>=intervals[i][1]){
                    if (newInterval[0]==intervals[i][1]){
                        p=i;
                        break;
                    }
                    if (i==intervals.length-1){
                        p=Integer.MAX_VALUE;
                    }
                }else {
                    p=i;break;
                }
            }

            for (int i=p;i<intervals.length;i++){
                if (newInterval[1]<=intervals[i][0]){

                    if (newInterval[1]==intervals[i][0]){
                        q=i+1;
                        break;
                    }
                    intervals[i-1][1]=newInterval[1];
                    q=i;break;
                }else if (newInterval[1]>=intervals[i][1]){
                    //System.out.println(111111);
                    if (newInterval[1]==intervals[i][1]){
                        q=i+1;
                        break;
                    }
                    if (i==intervals.length-1){
                        //System.out.println(111111);
                        intervals[i][1]=newInterval[1];
                    }
                    q=i+1;
                }else {

                        q=i+1;
                   break;
                }
            }

            System.out.println(p+""+q);

            if (p==Integer.MAX_VALUE){
                for (int i=0;i<intervals.length;i++){
                    list.add(intervals[i]);
                }
                list.add(newInterval);
            }else{
                for (int i=0;i<p;i++){
                    list.add(intervals[i]);
                }
                list.add(new int[]{intervals[p][0],intervals[q-1][1]});
                for (int i=q;i<intervals.length;i++){
                    list.add(intervals[i]);
                }
            }
*/

            return list.toArray(new int[list.size()][]);
        }
    }
}
