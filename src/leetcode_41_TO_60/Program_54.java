package leetcode_41_TO_60;

import java.util.ArrayList;
import java.util.List;

public class Program_54 {//Spiral Matrix  大大卷数组 螺旋  白白耗费一下午 应该看答案但总是觉得意犹未尽 而且
    //应该观察出一个很好的就觉方案 在套路上 而且套路上能够自洽自救

    public static void main(String []args){
        System.out.println(new Solution().spiralOrder(new int[][]{

        }));
    }
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer>list=new ArrayList<>();
            if (matrix.length==0)return list;
           // int p=matrix[0].length;int q=matrix.length;
            boolean [][]boo=new boolean[matrix.length][matrix[0].length];
            int len=matrix[0].length*matrix.length;
            //System.out.println(matrix[0].length+""+matrix.length);
            int l=0;int  model=0;int key=0;int p=0,q=0;//int min=Math.min(matrix[0].length,matrix.length);
            //addList(matrix,list,0,0);
            while (len>0){
               //key=l/2;
               //System.out.println(p+""+q);
                if (model==0){
                    if ( q<matrix[0].length&&boo[p][q]==false){
                        addList(matrix,list,p,q);
                        boo[p][q]=true;
                        q++;
                        //if (q>matrix[0].length-1)q=matrix[0].length-1;
                        len--;
                    }else {
                        model++;
                        q--;
                       p++;
                       // System.out.println(p+""+q);
                    }
                }else if (model==1){
                    if (p<matrix.length&&boo[p][q]==false){
                        // list.add(matrix[0][q++]);\
                        addList(matrix,list,p,q);boo[p][q]=true;p++;
                        //if (p>matrix.length-1)p=matrix.length-1;
                        len--;
                    }else {
                        p--;
                        q--;
                        model++;
                       // System.out.println(p+""+q);
                    }
                }else if (model==2){
                    if (q>=0&&boo[p][q]==false){
                        addList(matrix,list,p,q); boo[p][q]=true;
                        q--;
                        len--;
                    }else {
                        q++;
                        p--;
                        model++;
                    }
                }else if (model==3){
                    if (p>=0&&boo[p][q]==false){

                        addList(matrix,list,p, q); boo[p][q]=true;
                        p--;
                        //System.out.println(p+""+q);
                        //System.out.println(p+""+q);
                        len--;
                    }else {
                        //System.out.println(p+""+q);
                        p++;q++;
                        model=0;
                        l++;
                    }
                }
                /*
                Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
                Memory Usage: 34.4 MB, less than 99.84% of Java online submissions for Spiral Matrix.
                完全靠自己做的 啊啊啊啊啊啊
                 */

            }
            return list;
        }

        private void addList(int[][] matrix, List<Integer> list,int i,int j){
            list.add(matrix[i][j]);
        }
    }
}
