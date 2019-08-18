package leetcode_61_TO_80;

import java.nio.channels.SocketChannel;

public class Program_63 {//Unique Paths2 有阻碍的网格的唯一路径 m and n will be at most 100.
    /*
    Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
     */

    public static void main(String []args){
        Solution solution=new Solution();

        System.out.println( solution.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        //System.out.println(solution.uniquePaths(1,1));
    }

    static class Solution {//不清楚这个题目设置的障碍是否是单个的
        //果然 1不是单个的 我就知道  只能重头开始DP9


        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            /*int p=-1,q=-1;
            for (int i=0;i<obstacleGrid.length;i++){
                for (int j=0;j<obstacleGrid[0].length;j++){
                    if(obstacleGrid[i][j]==1){
                        p=i;q=j;break;
                    }
                }
            }
           // if (p==-1&&q==-1)return 1;
            if (p==-1){
                return uniquePaths(obstacleGrid.length,obstacleGrid[0].length);
            }

            int m1=uniquePaths(p+1,q+1);
            int m2=uniquePaths(obstacleGrid.length-p,obstacleGrid[0].length-q);
            int m3=uniquePaths(obstacleGrid.length,obstacleGrid[0].length);
            int m4=m3-m1*m2;
            return m4;
        }

        public int uniquePaths(int m, int n) {//原来要用到DP啊

         *//*   if (m<1||n<1)return 0;
            if (m==1||n==1)return 1;
            if(m+n<=3)return 1;
            if (m==2&&n==2)return 2;
            int p=m+n-2;
            int k=p*(p-1)/2;*//*
            int mat[][]=new int[m][n];
            for (int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if (j==0||i==0)
                        mat[i][j]=1;
                    else
                        mat[i][j]=mat[i-1][j]+mat[i][j-1];
                }
            }
            return mat[m-1][n-1];*/

          /*  for (int i=0;i<obstacleGrid.length;i++){
                for (int j=0;j<obstacleGrid[0].length;j++){
                  if (i==0){
                      if (obstacleGrid[i][j]==1){
                          obstacleGrid[i][j]=-1;
                      } else if (obstacleGrid[i][j]==0){
                          obstacleGrid[i][j]=1;
                      }else if (obstacleGrid[i][j-1]<0){
                          obstacleGrid[i][j]=-1;
                      }

                  }else if (j==0){
                      if (obstacleGrid[i][j]==1){
                          obstacleGrid[i][j]=-1;
                      }else if (obstacleGrid[i][j]==0){
                          obstacleGrid[i][j]=1;
                      }else if (obstacleGrid[i-1][j]<0){
                          obstacleGrid[i][j]=-1;
                      }
                  }
                  else if (i!=0&&j!=0){
                      obstacleGrid[i][j]=obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
                  }
                }
            }*/
            for (int i=0;i<obstacleGrid.length;i++){
                for (int j=0;j<obstacleGrid[0].length;j++) {
                    if (obstacleGrid[i][j]==1){
                        obstacleGrid[i][j]=0;
                    }else if(i==0&&j==0){//巧妙的运气初始值
                        obstacleGrid[i][j]=1;
                    }else if(i==0){
                        obstacleGrid[i][j]=obstacleGrid[i][j-1];
                    }else if(j==0){
                        obstacleGrid[i][j]=obstacleGrid[i-1][j];
                    }else {
                        obstacleGrid[i][j]=obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
                    }

                }
                }
            /**
             * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths II.
             * Memory Usage: 38.7 MB, less than 83.08% of Java online submissions for Unique Paths II.
             * 其实这就是我的意思啊 逻辑要分辨的清楚明晰
             */

            return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];

        /*    int width = obstacleGrid[0].length;
            int[] dp = new int[width];
            dp[0] = 1;
            for (int[] row : obstacleGrid) {
                for (int j = 0; j < width; j++) {
                    if (row[j] == 1)
                        dp[j] = 0;
                    else if (j > 0)
                        dp[j] += dp[j - 1];
                }
            }
            return dp[width - 1];//dpj 代表top dp j-1 代表left  应该明确用dp 法*/
        }
    }
}
