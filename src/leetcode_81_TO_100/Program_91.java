package leetcode_81_TO_100;

import java.util.ArrayList;

public class Program_91 {
    /*91. Decode Ways medium解码方式 所以限定位次解码很关键  对人最好不要客气 而且是当面的不客气
    中产阶级如何保持优势下去 要靠 智商情商 勤奋不懈带

    我日 dp 白白苦思冥想
    Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
     */

    public static void main(String args[]){
        Solution solution=new Solution();
        int m=solution.numDecodings("226");
        System.out.println(m);
    }
    static class Solution {
        int q=0;

        public int numDecodings(String s) {
            if (s==null||s.length()==0){
                return 0;
            }
            if (s.length()==1)return 1;
            char k[]=s.toCharArray();
            int p[]=new int[k.length];

            for (int i=0;i<k.length;i++){
                p[i]=k[i]-'0';
            }
            backTrace(p,0);

            return q;
        }
//这个为啥要backtrace 我有点搞不懂  突然懂了
        void backTrace(int p[],int d){
            if (d>=p.length||d+1>=p.length){
                q++;
                return;
            }
            int value=p[d]*10+p[d+1];
            if (value>=1||value<=26){
                backTrace(p,d+1);
            }else {
                backTrace(p,d+2);
                q++;
            }
            return;
        }
    }
}
