package leetcode_81_TO_100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Program_98 {
    public static void main(String args[]){
        Program_98.Solution solution=new Program_98.Solution();
        System.out.println(solution.isValidBST(new Program_98().constructTree(new Integer[]{-2147483648,null,2147483647})));
    }
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

   //执行用时：
    //2 ms
    //, 在所有 Java 提交中击败了
    //28.35%
    //的用户
    //内存消耗：
    //38.4 MB
    //, 在所有 Java 提交中击败了
    //7.50%
    //的用户

    public  TreeNode constructTree(Integer[] nums){//固定创建树的方法 我必须要学  栈方法中序遍历
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

    static class Solution {
        ArrayList<Integer>list=new ArrayList<>();
          int leftMin=Integer.MAX_VALUE , rightMax=Integer.MIN_VALUE;boolean isr=true;
        public boolean isValidBST(TreeNode root) {
            if (root==null)return false;
            leftMin=root.val;rightMax=root.val;
            //aaa(root);
            inOrderTraversal(root);
            System.out.println(list);
            for (int i=1;i<list.size();i++){
                if (list.get(i)>list.get(i-1))continue;
                else return false;
            }
            return isr;
        }

        public  void inOrderTraversal(TreeNode node){
            if(node == null){
                return;
            }else{
                inOrderTraversal(node.left);
                list.add(node.val);
                inOrderTraversal(node.right);
            }
        }
        //错了 应该去中序遍历
        void aaa(TreeNode root){
            if (root.left==null||root.left.val>leftMin)return;
            if (root.left.val<=leftMin){
                leftMin=root.left.val;aaa(root.left);aaa(root.right);
            }
            if (root.right==null||root.right.val<rightMax)return;
            if (root.right.val>=rightMax){
                rightMax=root.right.val;
                aaa(root.left);aaa(root.right);  //isr=true;
            }

        }
    }
}
