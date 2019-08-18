package leetcode_41_TO_60;

public class Program_59 {//Spiral Matrix II  螺旋矩阵2 给出n输出n阶螺旋矩阵

    //今天必须学会的 rust语言 以及很多技术 超过10个 每次都像第一年那样会很多东西  追赶google的脚步
    public static void main(String []args){
        Solution solution=new Solution();
        int [][]mat=solution.generateMatrix(3);
        System.out.println(mat[2][2]);
    }
    static class Solution {
        public int[][] generateMatrix(int n) {
            if(n==0)return null;
            int [][]mat=new int[n][n];
            mat[0][0]=1;
            int p=1;int j=0,k=0;int tem=0;
            while (p<n*n){
                //System.out.println(p);
               if (tem==0){
                    k++;
                   if ((k)<n&&mat[j][k]==0){
                       mat[j][k]=p+1;
                       p++;
                   }else {
                       k--;
                       tem++;
                   }
               }else if (tem==1){
                   j++;
                   if (j<n&&mat[j][k]==0){
                       mat[j][k]=p+1;
                       p++;
                   }else {
                       j--;
                       tem++;
                   }
               }else if (tem==2){
                    k--;
                   if (k>=0&&mat[j][k]==0){
                       mat[j][k]=p+1;
                       p++;
                   }else {
                       k++;
                       tem++;
                   }
               }else if (tem==3){
                   j--;
                   if (j>=0&&mat[j][k]==0){
                       mat[j][k]=p+1;
                       p++;
                   }else {
                       j++;
                       tem=0;
                   }
               }

            }
            return mat;
        }
        /*
        Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix II.
Memory Usage: 34.3 MB, less than 8.33% of Java online submissions for Spiral Matrix II.
 回家玩了近半个月 没刷题 刷题效率现在是1小时两题 恐怖的刷题效率
         */
    }
}
