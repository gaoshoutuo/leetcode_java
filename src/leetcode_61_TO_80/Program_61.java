package leetcode_61_TO_80;

public class Program_61 {//    Output: 4->5->1->2->3->NULL  旋转队列 Input: 1->2->3->4->5->NULL, k = 2    Output: 4->5->1->2->3->NULL
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     *
     * Input: 1->2->3->4->5->NULL, k = 2
     * Output: 4->5->1->2->3->NULL
     * Explanation:
     * rotate 1 steps to the right: 5->1->2->3->4->NULL
     * rotate 2 steps to the right: 4->5->1->2->3->NULL
     * 看招聘学语言 还是说我真正懂得学技术
     * woc 听了这些同学的成功实例 我瞬间就自卑了 看来我混的太差了
     * 荒废的一天 难受啊
     * 不急不徐 你有你的辉煌 相信这一点 做一些真正的事情出来
     * 一点点的短暂的突破 不要高兴太早 我们的目标是星辰大海
     */

     static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }


    }

    public static void main(String []args){
         Solution solution=new Solution();
         ListNode head=new ListNode(1);
        ListNode phead=head;
         for(int i=1;i<2;i++){
             ListNode next=new ListNode(i+1);
             phead.next=next;
             phead=next;
         }
       /*  for (int i=0;i<5;i++){
             System.out.println( head.val);
             head=head.next;
         }*/
       //solution.lastOneNode(head,5);
        //solution.lastTwoNode(head,5);
         ListNode head2=solution.rotateRight(head,2);
        for (int i=0;i<5;i++){
            System.out.println( i+":"+head2.val);
            head2=head2.next;
        }
    }
   static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head==null)return null;
            int p=0;
            ListNode node=head;
            do {
                node=node.next;
                //head.next=node.next;
                p++;
            }
            while (node!=null);
            if (p==1)return head;
            k=k%p;
            ListNode lastOne=null;
            ListNode lastTwo=null;
            for (int i=0;i<k;i++){
                lastOne=lastOneNode(head,p);
                lastTwo=lastTwoNode(head,p);
                lastOne.next=head;
                lastTwo.next=null;
                head=lastOne;
                //System.out.println(lastOne.val+""+lastTwo.val);
            }

            //System.out.println(p);
            return head;
        }

    /*   public void makeNode(ListNode head,int len){
           ListNode lastOne=head,lastTwo=head;
           len=len-1;
           do {
               lastOne=lastOne.next;
               len--;
           }while (len>0);
           System.out.println(lastOne.val);
       }*/

       public ListNode lastOneNode(ListNode head,int len){
           ListNode lastOne=head;
           len=len-1;
           while (len>0) {
               lastOne=lastOne.next;
               len--;
           }
           //System.out.println(lastOne.val);
           return lastOne;
       }

       public ListNode lastTwoNode(ListNode head,int len){
           ListNode lasTwo=head;
           len=len-1;
           while (len>1){
               lasTwo=lasTwo.next;
               len--;
           }
            //System.out.println(lasTwo.val);
           return lasTwo;
       }
    }
    /**
     * Runtime: 1 ms, faster than 27.73% of Java online submissions for Rotate List.
     * Memory Usage: 36 MB, less than 100.00% of Java online submissions for Rotate List.
     * 我这不是在刷题啊 我这是在杀题目啊
     */


}
