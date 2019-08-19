package leetcode_61_TO_80;

public class Program_70 {//
    /*
    70. Climbing Stairs easy 爬楼梯
    Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
     */

    public static void main(String []args){
        Solution solution=new Solution();
        System.out.println(solution.climbStairs(5));
    }

    static class Solution {// 纯粹自己写的 会不会超时啊 a few seconds ago	Time Limit Exceeded	N/A	N/A	java
        // 发现了这就是斐波那契数列 要叠算  22，33，45，58，613  就相当与第六层是第五层+第4层 这种意思
        /*int p=0;
        public int climbStairs(int n) {
            reI(n);
            return p;
        }
        public void reI(int n){
            if (n>0){
                reI(n-1);
                reI(n-2);
            }else if (n==0){
                p++;
                return;
            }
        }*/
        public int climbStairs(int n) {
            if(n <= 0) return 0;
            if(n == 1) return 1;
            if(n == 2) return 2;
            int a1=0,a2=1,a3=2;
            for(int i=2;i<n;i++){
                a1=a2+a3;
                a2=a3;
                a3=a1;
            }
            return a1;
        }
        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
         * Memory Usage: 32.9 MB, less than 5.26% of Java online submissions for Climbing Stairs.
         */
    }
}
