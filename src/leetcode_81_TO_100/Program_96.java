package leetcode_81_TO_100;

public class Program_96 {

    public static void main(String args[]){
        Program_96.Solution solution=new Program_96.Solution();
        System.out.println(solution.numTrees(2));
    }
    //答案是抄的 但是这种卡特兰 DP就很有意思好吧   还是得去弄计算机算法 光数据结构还不够  至于5大算法我都不怎么能够去承认
    //我认知的 就是 d0 =1 d1=1 d2 =d0*d1+d1*d0  d3=d0*d2+d1*d1+d2*d0 非常有趣的递归性质 不一定是Java  甚至我感觉可以用lisp来书写
    //找了半天 racket的编辑器 看起来还是vscode靠谱一点 而且我之前关于jetbrains添加racket编辑的方法其实是 leetcode新增了racket语言解题

    //leetcode 96题  我了解dp  我看过sicp 的阶段性得到答案  原来我无意中学会了DP
    static class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n+1];
            dp[0] = 1;
            dp[1] = 1;
            for(int i = 2; i < n + 1; i++)
                for(int j = 1; j < i + 1; j++)
                    dp[i] += dp[j-1] * dp[i-j];
            return dp[n];
        }
    }
}
