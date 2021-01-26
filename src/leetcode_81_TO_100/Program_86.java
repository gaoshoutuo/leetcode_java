package leetcode_81_TO_100;

import java.util.LinkedList;
import java.util.Queue;

public class Program_86 {
    /*
    给定链表和值x，对其进行分区，使得小于x的所有节点都在大于或等于x的节点之前。

    Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
     */

     // Definition for singly-linked list. 这个是我写的么 时隔这么久 还是英雄所见略同
    //也可以两根线的线头来搞
     public static void main(String []args){
         Solution solution=new Solution();
         int []o=new int[]{4,3,2,5,2};
         ListNode head=new ListNode(1);
         ListNode Rhead=head;
         for (int i=0;i<o.length;i++){
             head.next=new ListNode(o[i]);
             head=head.next;
         }

         ListNode result=solution.partition(Rhead,3);
         while (result!=null){
             System.out.println(result.val);
             result=result.next;
         }
     }
     public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
      //Runtime: 2 ms, faster than 6.93% of Java online submissions for Partition List.
    //Memory Usage: 39.9 MB, less than 5.77% of Java online submissions for Partition List.
    //Next challenges:  一次过 但是估计写的不好

    static class Solution {
        public ListNode partition(ListNode head, int x) {
            if (head==null)return null;
            Queue<Integer>queue1=new LinkedList<>();
            Queue<Integer>queue2=new LinkedList<>();
            ListNode pNext=head;
            int k=0;
            while (pNext!=null){
                if (checkVal(pNext.val,x)){
                    queue1.offer(pNext.val);
                }else {
                    queue2.offer(pNext.val);
                }
                k++;
                pNext=pNext.next;
            }
            ListNode p=new ListNode(Integer.MIN_VALUE);
            ListNode pCopy=p;
            for (int i=0;i<k;i++){
                if (queue1.peek()!=null){
                   p.next= new ListNode(queue1.poll());
                   p=p.next;
                   continue;
                }
                if (queue2.peek()!=null){
                    p.next= new ListNode(queue2.poll());
                    p=p.next;
                    continue;
                }

            }
            return pCopy.next;
        }
        boolean checkVal(int t1,int t2){
            return t1<t2;
        }
    }
}
