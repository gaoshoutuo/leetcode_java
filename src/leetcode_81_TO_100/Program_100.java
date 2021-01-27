package leetcode_81_TO_100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Program_100 {//相同的树
    //我的方法太繁琐 答案不再这里 递归的语义化处理
    public static void main(String args[]){
        Solution solution=new Solution();
        System.out.println(solution.isSameTree(solution.constructTree(new Integer[]{1,2,3})
        ,solution.constructTree(new Integer[]{1,2,3})));
    }

      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
        //继续中序遍历
        static class Solution {
          boolean isF=true;
            ArrayList<Integer>list=new ArrayList<>();
        public boolean isSameTree(TreeNode p, TreeNode q) {
            ArrayList<Integer>list1=inOrderTraversal(p,new ArrayList<>());
            inOrderTraversal2(q,0);
            //ArrayList<Integer>list2=inOrderTraversal(q,new ArrayList<>());
            System.out.println(list1);  //System.out.println(list2);
            return isF;
        }
            ArrayList<Integer> inOrderTraversal(TreeNode node, ArrayList<Integer>list){
                if(node == null){
                    return list;
                }else{
                    inOrderTraversal(node.left,list);
                        list.add(node.val);
                        inOrderTraversal(node.right,list);
                }
                return list;
            }

            void inOrderTraversal2(TreeNode node,int position){
                if(node == null){
                    return;
                }else{
                    inOrderTraversal2(node.left,position+1);
                   /* if (list.get(position)!=node.val){
                        isF=false;//System.out.println(list.get(position)+""+node.val);
                    }*/
                    System.out.println(list.get(position)+""+node.val);
                    inOrderTraversal2(node.right,position+1);
                }
            }
            TreeNode constructTree(Integer[] nums){//固定创建树的方法 我必须要学  栈方法中序遍历
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
            void inOrderTraversal3(TreeNode node,int position){
                if(node == null){
                    return;
                }else{
                    inOrderTraversal2(node.left,position+1);
                    if (list.get(position)!=node.val){
                        isF=false;
                        System.out.println(1111);
                    }
                        inOrderTraversal2(node.right,position+1);
                }
            }
    }
}
