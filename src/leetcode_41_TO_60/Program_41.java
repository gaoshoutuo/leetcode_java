package leetcode_41_TO_60;

public class Program_41 {//s`首个缺少的正数 hard on o1 不能排序  应当承认hard题目就像高考的最后一题一样这辈子是无缘了

    public static void main(String []args){
        Solution solution=new Solution();
        int[] nums={1,2,2,2};
        //int[] nums={1,2,0};
        System.out.println(solution.firstMissingPositive2(nums));
    }

    static class Solution{
    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;

        // 1. mark numbers (num < 0) and (num > n) with a special marker number (n+1)
        // (we can ignore those because if all number are > n then we'll simply return 1)
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
        // note: all number in the array are now positive, and on the range 1..n+1

        // 2. mark each cell appearing in the array, by converting the index for that number to negative
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > n) {
                continue;
            }
            num--; // -1 for zero index based array (so the number 1 will be at pos 0)
            if (nums[num] > 0) { // prevents double negative operations
                nums[num] = -1 * nums[num];
                System.out.println(nums[num]);
            }
        }

        // 3. find the first cell which isn't negative (doesn't appear in the array)
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }

        // 4. no positive numbers were found, which means the array contains all numbers 1..n
        return n + 1;
    }

        public int firstMissingPositive(int[] nums) {//思路就是找到相邻最小正数字
      /*      for(int i=1;i<nums.length;i++){
                if (nums[i]-nums[i-1]>1&&nums[i-1]>0&&nums[i]>0){
                    min=nums[i-1]+1;
                }else if (nums[i]-nums[i-1]<-1&&nums[i-1]>0&&nums[i]>0){
                    min=nums[i]+1;
                }else if (nums[i]-nums[i-1]<1&&nums[i]-nums[i-1]>-1){
                 if (nums[i-1]>0&&min<nums[i-1]+1)
                    min=nums[i-1]+1;
                else if (nums[i-1]<=0){
                    if (nums[i]>0&&min>nums[i]&&min!=1) min=nums[i]-1;
                 }


                }
            }*/

         /*   for(int i=1;i<nums.length;i++){
                if (nums[i-1]>0&&nums[i]>0&&min>nums[i])min=nums[i]+1;
                else{

                }
            }*/
         /*
         Runtime: 0 ms, faster than 100.00% of Java online submissions for First Missing Positive.
Memory Usage: 34.7 MB, less than 99.81% of Java online submissions for First Missing Positive.
Next challenges:
          */

         int n=nums.length;
         for (int i=0;i<n;i++){
             if (nums[i]>n||nums[i]<=0)nums[i]=n+1;
         }

            for (int i=0;i<n;i++){
                int num=Math.abs(nums[i]);
                if (num>n){continue;}
                num--;
                if (nums[num]>0)nums[num]=-nums[num];
            }
            for (int i=0;i<n;i++){
                if (nums[i]>=0)return i+1;
            }


            return n+1;
        }

        private void swap(int[] A, int i, int j){
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
}
