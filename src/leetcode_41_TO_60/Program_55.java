package leetcode_41_TO_60;

public class Program_55 {//Jump Game  给出数组 是否能够跳到最后 imdex  恩我的技术敏感度数有点下降了 所以要分配时间不能全

    //刷题 也要学新技术 查漏补缺 基本就是 flutter spring 英语 文章 语言  乐谱  有没有什么办法一写出就能够知道自己对不对
    //提前做好各类打算 先从找工作开始  积极乐观的心态 未雨绸缪的打算  做出成果 做在实处

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.canJump(new int[]{3,1,1,1,4}));
    }

    static class Solution {//估计也要用backyrace
        int bb=0;boolean []bbl;
        public boolean canJump(int[] nums) {//思路 就是跳入pi 确认pi>j 则跳入 p[i+j]  return 总之是递归 有难度
            if (nums.length==0)return false;
            if (nums.length==1)return true;
            bbl=new boolean[nums.length];
            xx(nums,0,nums[0],0);
            return bb>0?true:false;
            /*
            Runtime: 2 ms, faster than 42.46% of Java online submissions for Jump Game.
Memory Usage: 42.1 MB, less than 20.29% of Java online submissions for Jump Game.
牙痛做到大半夜 坚持终于做出来了 还是在逻辑上要注意  还是要一块一块的定义好 清晰的了解这一切
今天有点累 加上牙痛 很奇怪 以后的健身项目可能得放到晚上了，而且睡眠时间得一定满足
再做一天与玩家 稀里糊涂的缴费  大环境一直在变化  得不停的变化自己更新自己啊 你说多累 这是无奈的选择不然更累
             */
        }

        private void xx(int[] nums,int p,int j,int l){

            if (nums[p]>l&&bbl[p]==false){//前进
                if (p+nums[p]>=nums.length-1){
                    bb=1; return;
                }
                bbl[p]=true;
                xx(nums, p+nums[p],nums[p],0);
            }
            if (nums[p]<=l||bbl[p]==true){//后腿

                if (j>0){//后退
                    //System.out.println(p+""+nums[p]);
                    bbl[p]=true;
                    if (p<1)return;
                    --p;--j;
                    xx(nums, p,j,++l);
                }
                //p--;if (p<0)return;
            }


        }
    }
}
