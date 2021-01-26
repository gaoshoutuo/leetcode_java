package leetcode_81_TO_100;

public class Program_81 {// 我的办法不奏效
    /*
    81. Search in Rotated Sorted Array II medium  旋转数组
    (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
    Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
ologn
     */

    /**
     * i know it
     */
    public static void main(String []args){
        Solution solution=new Solution();
        int []nums=new int[]{3,1};
        boolean r=solution.search2(nums,3);
        System.out.println(r);
    }

    static class Solution {
        public boolean search(int[] nums, int target) {
            if (nums.length==0)return false;
            if (nums.length==1){
                return nums[0] == target;
            }
            int first=0,last=nums.length-1;
            while (first<=last){
                int mid =(first+last)/2;
                if (last-first==0){
                    return target==nums[first];
                }
                System.out.println("--"+first+"--"+mid+"--"+last);
                if (nums[mid]<=nums[last]&&nums[mid]<=nums[first]){//前小后大
                    //System.out.println("--"+first+"--"+mid+"--"+last);
                    if (nums[mid]==target){
                        return true;
                    }else if (target>nums[mid]&&target<=nums[last]){
                        first=mid+1;
                    }else {
                        last=mid;
                    }
                }else if (nums[mid]>nums[last]&&nums[mid]>nums[first]){//前大后小  这里不能仅仅取前半部分 非常重要
                    //System.out.println("--"+first+"--"+mid+"--"+last);
                    if (nums[mid]==target){
                        return true;
                    }else if (target<nums[mid]&&target>=nums[first]){
                        last=mid;
                    }else{
                        first=mid+1;
                    }
                }
                else if (nums[mid]>nums[first]&&nums[mid]<nums[last]){
                    //System.out.println("--"+first+"--"+mid+"--"+last);
                    if (nums[mid]==target){
                        return true;
                    }else if (target>nums[mid]){
                        first=mid+1;
                    }else {
                        last=mid;
                    }
                }else {//  、·、·\ 斜沟
                    if (target!=nums[first]){
                        if (target!=nums[last]){
                            return false;
                        }else return true;
                    }else return true;
                }
            }
            return false;
        }



        public boolean search2(int[] nums, int target) {//之前思路一片馄饨 没有探索进去 应该当注意连续的区分
            //首先区分连续区间 再去选择 first last
            if (nums.length==0)return false;
            if (nums.length==1){
                return nums[0] == target;
            }
            int first=0,last=nums.length;

            while (last>first){
                int mid=(first+last)/2;
                System.out.println("--"+first+"--"+mid+"--"+last);
                if (nums[mid] == target) return true;
                if (nums[mid]>nums[first]){//这说明 first到mid是连续区间
                    if (target>=nums[first]&&target<nums[mid]) last=mid;
                    else first=mid+1;
                }else if (nums[mid]<nums[first]){//这说明 mid到last是连续区间
                    if (target>nums[mid]&&target<nums[first]) first=mid+1;
                    else last=mid;
                }else {
                    first++;
                }
            }

            /**
             * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array II.
             * Memory Usage: 39.9 MB, less than 33.80% of Java online submissions for Search in Rotated Sorted Array II.
             * 大神的结晶 思考的太少
             * 
             */
            return false;
        }
        boolean checkTarget(int[] nums,int target,int first,int last){
            int mid=(first+last)/2;
            if (nums[mid]==target){
                return true;
            }else if (target>nums[mid]){

            }
            return false;
        }
    }
}
