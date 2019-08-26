package leetcode_61_TO_80;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Program_73 {//
    /*
    73. Set Matrix Zeroes medium
    Input:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
     */

    public static void main(String []args){
        Solution solution=new Solution();
        solution.setZeroes(new int[][]{
                {1,1,1},{1,0,1},{1,1,1}
        });
    }

    /**
     * Runtime: 5 ms, faster than 8.93% of Java online submissions for Set Matrix Zeroes.
     * Memory Usage: 43.9 MB, less than 91.43% of Java online submissions for Set Matrix Zeroes.
     * 一次通过 感觉很舒服
     */

    static class Solution {//使用不变的空间
        public void setZeroes(int[][] matrix) {
          /*  class temp{
                int a;int b;
                public temp(int a, int b) {
                    this.a = a;
                    this.b = b;
                }

            }*/
            Set<Integer> set1=new HashSet<>();
            Set<Integer> set2=new HashSet<>();
            for (int i=0;i<matrix.length;i++){
                for (int j=0;j<matrix[0].length;j++){
                    if (matrix[i][j]==0){
                       //temp t=new temp(i,j);
                       set1.add(i);
                        set2.add(j);
                    }
                }
            }
            for (int i=0;i<matrix.length;i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (set1.contains(i)){
                        matrix[i][j]=0;
                    }
                    if (set2.contains(j)){
                        matrix[i][j]=0;
                    }
                }
            }
            /*if (p!=-1){
                for (int i=0;i<matrix.length;i++){
                    if (p-i>=0){
                        matrix[p-i][q]=0;
                    }
                    if (p+i<matrix.length){
                        matrix[p+i][q]=0;
                    }
                }

                for (int i=0;i<matrix[0].length;i++){
                    if (q-i>=0){
                        matrix[p][q-i]=0;
                    }
                    if (q+i<matrix[0].length){
                        matrix[p][q+i]=0;
                    }
                }
            }*/

        }
    }
}
