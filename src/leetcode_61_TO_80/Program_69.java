package leetcode_61_TO_80;

public class Program_69 {// 番茄工作法
    /*
    69. Sqrt(x) easy
    Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
             the decimal part is truncated, 2 is returned.

             找到那个迭代公式 去mateix 64 上面的介绍 一个有趣的人 王垠对于 有趣的 理论性的 有用的问题
             年轻的时间就不要浪费
     */
    public static void main(String []args){
        Solution solution=new Solution();
        System.out.println(solution.mySqrt(26));
    }

   static class Solution {
        int p=0;
        public int mySqrt(int x) {
            if(x==0)return 0;
            if(x==1)return 1;
            makeSq(x,0,x);
            return p;
        }
        public void makeSq(int x,int left,int right){
            if (right-left==1){
                p=left;
                return;
            }
            int mid=(left+right)/2;
            if (mid>x/mid){
                makeSq(x,left,mid);
            }else if (mid<x/mid){//mid*mid 不行啊
                makeSq(x,mid,right);
            }else {
                p=mid;return;
            }
        }
    }
    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Sqrt(x).
     * Memory Usage: 33.7 MB, less than 5.00% of Java online submissions for Sqrt(x).
     * Next challenges:
     * Valid Perfect Square
     * 一小时能够刷3道leetcode  虽然两道easy 1到medium
     */
}
