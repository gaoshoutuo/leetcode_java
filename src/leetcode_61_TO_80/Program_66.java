package leetcode_61_TO_80;

public class Program_66 {//66. Plus One
    /*
    Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
     */

    static class Solution {//果然跟我的猜想符合的很好
        public int[] plusOne(int[] digits) {
            for(int i=digits.length-1;i>=0;i--){
                if (digits[i]<9){
                    digits[i]++;
                    return digits;
                }
                digits[i]=0;
            }
            int []mat=new int[digits.length+1];
            mat[0]=1;
            return mat;
        }

        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
         * Memory Usage: 35.2 MB, less than 97.58% of Java online submissions for Plus One.
         */
    }
}
