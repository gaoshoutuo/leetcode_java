package leetcode_41_TO_60;

public class Program_48 {//数组顺时针转90度  做了半天结果是错的 心塞  玛德搞复杂了 算法刷 得第一有思路 然后不要直接写要去看
    //评论区 然后再写 要熟悉套路 虽然我对于回溯还是个dd  完蛋 二房东们回来了 难受啊  这种自由不容易啊

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
Memory Usage: 36.4 MB, less than 99.70% of Java online submissions for Rotate Image.
Next challenges:
     */

    public static void main(String []args){
        Solution2 solution2=new Solution2();
        //int[][] kk=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] kk=new int[][]{{5,1,9,11},{2,4,8,10},{13, 3, 6, 7},{15,14,12,16}};
        solution2.rotate(kk);
        for (int i=0;i<kk.length;i++){
            for (int j=0;j<kk.length;j++){
              System.out.println(kk[i][j]);
            }
        }
        System.out.println();
    }

   static class Solution {//思路影响 n-i+1个 替换行列 后续替换行列
        public void rotate(int[][] matrix) {

            for(int i=0;i<matrix.length;i++){
                int q=i;
                for (int j=matrix.length-1;j>=0;j--){
                    if (q>0){
                        //System.out.println(matrix[matrix.length-1-j][matrix.length-1-i]);
                        swap2(matrix,i,j);
                        q--;
                    }else {
                        if (i>0&&i%2==0)continue;
                        swap(matrix,i,j);
                    }
                }

              /*  for (int n=0;n<matrix.length;n++){

                }*/
            }

        }


        private void swap(int[][] A, int i, int j){
            int temp = A[i][j];
            A[i][j]=A[j][A.length-1-i] ;
            A[j][A.length-1-i]= temp;
        }

       private void swap2(int[][] A, int i, int j){
           int p=A.length-1-j;int q=i;
           //int p=A.length-1-j;int q=A.length-1-i;
           int temp = A[p][q];
          A[p][q] =A[j][A.length-1-i];
           A[j][A.length-1-i]= temp;
       }
    }

    static class Solution2 {//(swap(matrix[i][j], matrix[i][matrix.length-1-j])  刷算法题关键在于观察 本题其实很简单 就是先
        //ij行列互换 再行互换  试出来 构造出来 刷题得刷出套路 刷题没办法正儿八经的学 或者行换 再沿正对角线换
        public void rotate(int[][] matrix) {//行列换
            int n=matrix.length;
            for (int i=0;i<n;i++){
                for (int j=i;j<n;j++){
                    swap(matrix,i,j);
                }
            }

            for (int i=0;i<n;i++){//列互换
                for (int j=0;j<n/2;j++){
                    swap2(matrix,i,j);
                    }
                }
        }

        private void swap(int[][] A, int i, int j){
            int temp = A[i][j];
            A[i][j]=A[j][i] ;
            A[j][i]= temp;
        }
        private void swap2(int[][] A, int i, int j){
            int temp =A[i][j];
            A[i][j]=A[i][A.length-1-j];
            A[i][A.length-1-j]=temp;
        }
    }
}
