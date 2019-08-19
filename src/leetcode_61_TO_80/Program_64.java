package leetcode_61_TO_80;

public class Program_64 {// Minimum Path Sum  最小路径和
/*
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

    public static void main(String []args){
        Solution solution=new Solution();
        System.out.println(solution.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));

    }

    static class Solution {//思路就是开一个新的数组然后做累加 每个cell填写左上最小累加 输出最后之n-1 n-1
        public int minPathSum(int[][] grid) {
            //int [][]mat=new int[grid.length][grid[0].length];
            for (int i=0;i<grid.length;i++){
                for (int j=0;j<grid[0].length;j++){
                   if (i==0&&j==0){
                       grid[i][j]=grid[i][j];
                   }else if (i==0){
                       grid[i][j]= grid[i][j]+ grid[i][j-1];
                   }else if (j==0){
                       grid[i][j]= grid[i-1][j]+ grid[i][j];
                   }else{
                       grid[i][j]=Math.min(grid[i-1][j]+grid[i][j],grid[i][j]+grid[i][j-1]);
                   }
                }
            }
            return grid[grid.length-1][grid[0].length-1];
        }
    }
    /**
     * Runtime: 2 ms, faster than 90.21% of Java online submissions for Minimum Path Sum.
     * Memory Usage: 42.3 MB, less than 83.78% of Java online submissions for Minimum Path Sum.
     * 只能说这是速战速决 非常快速的刷题
     */
}
