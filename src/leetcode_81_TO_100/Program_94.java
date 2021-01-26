package leetcode_81_TO_100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Program_94 {// 开始树的环节了 二叉树的中序遍历
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    /**
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [1,3,2]
     *
     * 10234
     *
     */
    public static void main(String args[]){
        Solution solution=new Solution();

        System.out.println(solution.inorderTraversal(solution.constructTree(new Integer[]{})));
    }
   public static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {//递归很简单 迭代怎么做  栈迭代或者递归
            //建立二叉树 中序遍历
            //TreeNode treeNode=new TreeNode();
            ArrayList<Integer>list=new ArrayList<>();
           //if (root.val==0)return list;
           re(root,list);
            return list;
        }
        void re(TreeNode root, ArrayList<Integer> list){
            if (root.left!=null)re(root.left,list);//左
            if (root==null)//右
                return;else  list.add(root.val);
            if (root.right!=null)re(root.right,list);//中
            //re(root.left,list);

        }
        public static TreeNode constructTree(Integer[] nums){//固定创建树的方法 我必须要学  栈方法中序遍历
           if (nums.length == 0) return new TreeNode(0);
           Deque<TreeNode> nodeQueue = new LinkedList<>();
           // 创建一个根节点
           TreeNode root = new TreeNode(nums[0]);
           nodeQueue.offer(root);
           TreeNode cur;
           // 记录当前行节点的数量（注意不一定是2的幂，而是上一行中非空节点的数量乘2）
           int lineNodeNum = 2;
           // 记录当前行中数字在数组中的开始位置
           int startIndex = 1;
           // 记录数组中剩余的元素的数量
           int restLength = nums.length - 1;

           while(restLength > 0) {
               // 只有最后一行可以不满，其余行必须是满的
//            // 若输入的数组的数量是错误的，直接跳出程序
//            if (restLength < lineNodeNum) {
//                System.out.println("Wrong Input!");
//                return new TreeNode(0);
//            }
               for (int i = startIndex; i < startIndex + lineNodeNum; i = i + 2) {
                   // 说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
                   if (i == nums.length) return root;
                   cur = nodeQueue.poll();
                   if (nums[i] != null) {
                       cur.left = new TreeNode(nums[i]);
                       nodeQueue.offer(cur.left);
                   }
                   // 同上，说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
                   if (i + 1 == nums.length) return root;
                   if (nums[i + 1] != null) {
                       cur.right = new TreeNode(nums[i + 1]);
                       nodeQueue.offer(cur.right);
                   }
               }
               startIndex += lineNodeNum;
               restLength -= lineNodeNum;
               lineNodeNum = nodeQueue.size() * 2;
           }

           return root;
       }

    }
}
