package leetcode_61_TO_80;

import java.nio.channels.SocketChannel;

public class Program_74 {
    /*
    74. Search a 2D Matrix medium
    Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false

大概明白了 要ologn吧
     */

    public static void main(String []args){
        Solution solution=new Solution();
        boolean b=solution.searchMatrix(new int[][]{
                {1,3}
        },1);
        System.out.println(b);
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
     * Memory Usage: 42.2 MB, less than 6.06% of Java online submissions for Search a 2D Matrix.
     * 我傻了 二分法 mid+1 尤其关键
     */

    static class Solution {
        boolean abc=false;
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length==0)return abc;
            int row=matrix.length;int column=matrix[0].length;
            int length=row*column-1;
            if (length<0)return abc;
           // System.out.println(length);
            me(0,length,target,matrix,row,column);
            return abc;
        }

        void me(int left,int right,int target,int[][] matrix,int row,int column){
            int mid=(left+right)/2;
            if (left==right){
                abc=matrix[mid/column][mid%column]==target?true:false;
                return;
            }
            //System.out.println("mid:"+mid+"left:"+left+"right:"+right);
            if (matrix[mid/column][mid%column]>target){
                me(left,mid,target,matrix,row,column);
            }else if (matrix[mid/column][mid%column]<target) {
                me(mid+1, right, target, matrix, row, column);
            }else if (matrix[mid/column][mid%column]==target){
                abc=true;
            }
        }
    }
}
