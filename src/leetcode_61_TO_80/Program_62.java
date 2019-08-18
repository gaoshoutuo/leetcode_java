package leetcode_61_TO_80;

public class Program_62 {//Unique Paths 网格的唯一路径  m and n will be at most 100.

    /*
    Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
     */
    public static void main(String []args){
        Solution solution=new Solution();

        System.out.println(solution.uniquePaths(7,3));
    }
    static class Solution {
        public int uniquePaths(int m, int n) {//原来要用到DP啊

         /*   if (m<1||n<1)return 0;
            if (m==1||n==1)return 1;
            if(m+n<=3)return 1;
            if (m==2&&n==2)return 2;
            int p=m+n-2;
            int k=p*(p-1)/2;*/
         int mat[][]=new int[m][n];
         for (int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                 if (j==0||i==0)
                     mat[i][j]=1;
                 else
                     mat[i][j]=mat[i-1][j]+mat[i][j-1];
             }
         }
            return mat[m-1][n-1];
        }
        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
         * Memory Usage: 32.9 MB, less than 5.10% of Java online submissions for Unique Paths\
         * 这种dp的方法我记住了
         */
    }
}
