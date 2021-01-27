package leetcode_101_TO_200;

import ZJU_pat.Main;

import java.util.Deque;
import java.util.LinkedList;

public class Program_101 {//easy  验证对称二叉树 就是语义的递归我们树 左右相等


      /*
      class Solution {//或者后序遍历
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        if(p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
       */

    public class Solution {
        public boolean isSymmetric(Main.TreeNode root) {
            return isSy(root,root);
        }


        boolean isSy(Main.TreeNode root1, Main.TreeNode root2){
            if(root1== null && root2== null)
                return true;
            if(root1== null || root2 == null)
                return false;
            return (root1.val==root2.val)&&isSy(root1.left,root2.right)&&isSy(root1.right,root2.left);
        }
    }
}
