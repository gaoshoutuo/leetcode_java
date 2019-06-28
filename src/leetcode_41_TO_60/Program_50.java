package leetcode_41_TO_60;

public class Program_50 {//pow（n,x） -100<n<100 x属于integer

    public static void main(String []args){
        Solution solution=new Solution();
        //solution.myPow(2.5,5);
        System.out.println( solution.myPow(1.00012 ,123456));
    }


   static class Solution {//可以递归 句子奇异变幻  保留位数也要不吃不变
        //矩阵 奇异 qvd 这些我都忘记了  还是说说我的做法吧 就是安排  这里就很奇怪 明明取值范围这么大 却最后输出double 这部科学
        public double myPow(double x, int n) {
            if (x==0)return 0;
            if (x==0&&n==0)return 1;
            if (n==0)return 1;
            double xSet[]=new double[69];int p=0;
            if (n<0){
                n=-n;
                p=1;
            }
            xSet[34]=1;
            xSet[35]=x;
            xSet[33]=1/x;
            String binN=Integer.toBinaryString(n);
            char []binC=binN.toCharArray();
            double result=1;
            if (p==0){
                for (int i=0;i<binN.length();i++){
                    xSet[35+i+1]=Math.pow(xSet[35+i],2);
                }
                for (int i=0;i<binN.length();i++){
                    if (binC[i]=='1'){
                        result*=xSet[34-i+binN.length()];
                        //System.out.println(result);
                    }
                }

            }else{
                for (int i=0;i<binN.length();i++){
                    xSet[32-i]=Math.pow(xSet[33-i],2);
                }
                for (int i=0;i<binN.length();i++){
                    if (binC[i]=='1'){
                        result*=xSet[34+i-binN.length()];
                        //System.out.println(result);
                    }
                }
            }

            //System.out.println( binN+""+binN.length());
            //xSet[11+]

/*
Runtime: 1 ms, faster than 36.43% of Java online submissions for Pow(x, n).
Memory Usage: 33.8 MB, less than 18.35% of Java online submissions for Pow(x, n).
大胜利 完全凭借自己做的
 */

            return result;
        }
    }
}
