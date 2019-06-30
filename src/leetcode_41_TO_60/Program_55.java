package leetcode_41_TO_60;

public class Program_55 {//Jump Game  给出数组 是否能够跳到最后 imdex  恩我的技术敏感度数有点下降了 所以要分配时间不能全

    //刷题 也要学新技术 查漏补缺 基本就是 flutter spring 英语 文章 语言  乐谱  有没有什么办法一写出就能够知道自己对不对
    //提前做好各类打算 先从找工作开始  积极乐观的心态 未雨绸缪的打算  做出成果 做在实处

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.canJump(new int[]{3,8,2,0,0,1,5}));
    }

    static class Solution {//估计也要用backyrace
        int bb=0;boolean []bbl;
        public boolean canJump(int[] nums) {//思路 就是跳入pi 确认pi>j 则跳入 p[i+j]  return 总之是递归 有难度
            bbl=new boolean[nums.length];
            xx(nums,0,nums[0],0);
            return bb>0?true:false;
        }

        private void xx(int[] nums,int p,int j,int l){
            if (nums[p]>l){
                if (p+nums[p]>=nums.length-1){
                    bb=1; return;
                }
                bbl[p]=true;
                xx(nums, p+nums[p],nums[p],0);
                System.out.println(p+""+nums[p]);
            }
            if (nums[p]<=l){
              /*  if (bbl[p]==true){
                    return;
                }*/
                if (j>0){//后退
                    bbl[p]=true;
                    if (p<1)return;
                    xx(nums, --p,--j,l++);
                }
                //p--;if (p<0)return;
            }


        }
    }
}
