package leetcode_41_TO_60;

public class Program_53 {//Maximum Subarray 最长子列和

    public static void main(String []args){
        Solution solution=new Solution();

        System.out.println(    solution.maxSubArray(new int[]{-2,-1,-3,4,-1,2,1,-5,4}));
    }
    static class Solution {
        public int maxSubArray(int[] nums) {//3一个非常好的想法 如果 di-1 为负则以0相加 如果为正则 d=di-1+ai
            //if (nums.length==1)return nums[0]>0?nums[0]:0;
           // if (nums.length==1)return nums[0];
          /*  int d[]=new int[nums.length];//网友的解法
            d[0]=nums[0];
            int max=nums[0];
            for (int i=1;i<nums.length;i++){
                d[i]=nums[i]+(d[i-1]>0?d[i-1]:0);
                max=Math.max(d[i],max);
            }*/
            /*
            Runtime: 1 ms, faster than 91.08% of Java online submissions for Maximum Subarray.
Memory Usage: 41.5 MB, less than 5.01% of Java online submissions for Maximum Subarray.
             */
            //我的解法
        /*    if (nums.length==1)return nums[0];
            int d[]=new int[nums.length];
            d[0]=nums[0];
            int max=nums[0];
            for (int i=1;i<nums.length;i++){
                d[i]=nums[i]+d[i-1];
                if (d[i-1]<0)d[i]=nums[i];
                max=Math.max(d[i],max);
            }*/

            if (nums.length==1)return nums[0];
            //int d[]=new int[nums.length];
            //d[0]=nums[0];
            int max=nums[0];
            for (int i=1;i<nums.length;i++){
            /*    if (nums[0]<0)nums[0]=nums[i];
                else if (nums[0]>0&&nums[i]<0){
                    nums[0]=nums[i]+nums[0];
                    if (nums[0]<0){
                        nums[0]=0;
                    }//Runtime: 1 ms, faster than 91.08% of Java online submissions for Maximum Subarray.
                    //Memory Usage: 36.6 MB, less than 99.80% of Java online submissions for Maximum Subarray.
                }
                else if(nums[0]>=0&&nums[i]>=0) nums[0]=nums[i]+nums[0];
                max=Math.max(nums[0],max);*/
                if (nums[0]<0){
                    nums[0]=nums[i];
                    max=Math.max(nums[0],max);
                    continue;
                }
                    nums[0]=nums[i]+nums[0];
                    if (nums[0]<0){
                        nums[0]=0;
                    }
                max=Math.max(nums[0],max);
                    //Runtime: 1 ms, faster than 91.08% of Java online submissions for Maximum Subarray.
                //Memory Usage: 38.6 MB, less than 50.42% of Java online submissions for Maximum Subarray.
                /* 同一道题目的四种解法
                a few seconds ago	Accepted	1 ms	38.6 MB	java
2 minutes ago	Accepted	1 ms	36.6 MB	java
28 minutes ago	Accepted	1 ms	39.3 MB	java
32 minutes ago	Accepted	1 ms	41.5 MB	java
                 */
            }
            return max;
        }
    }

}
