package leetcode_81_TO_100;

public class Program_92 {//medium 反转链表  递归或者头插  递归两端递进
// 1-2-3-4-5  2 4    1-4-3-2-5

    public static void main(String []args){
        Solution solution=new Solution();
        ListNode head=new ListNode(1);
        ListNode keyHead=head;
        for (int i=0;i<5;i++){
            keyHead.next=new ListNode(i+2);
            keyHead=keyHead.next;
        }
        ListNode so=solution.reverseBetween(head,2,4);
        while (so!=null){
            System.out.print(so.val);
            so=so.next;
        }
    }
      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }

    static class Solution {
          //m-1->n  m->n+1  0->
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if(m==n)return head;
            ListNode pHead=new ListNode(Integer.MIN_VALUE);
            pHead.next=head;
            ListNode mNode=pHead;  ListNode nNode=pHead;
            for (int i=0;i<m-1;i++){
                mNode=mNode.next;
            }
            for (int i=0;i<m;i++){
                nNode=nNode.next;
            }
           //System.out.println(mNode.val+"=="+nNode.val);
            for (int i=0;i<n-m;i++){
                ListNode nodeT=mNode.next;// 关键
                mNode.next=nNode.next;
                nNode.next=nNode.next.next;
                mNode.next.next=nodeT;
               /* ListNode removed = nNode.next;
                nNode.next = nNode.next.next;
                removed.next = mNode.next;
                mNode.next = removed;*/
            }
            return pHead.next;

            /**
             * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
             * Memory Usage: 37.4 MB, less than 11.36% of Java online submissions for Reverse Linked List II.
             */
          /*  ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode g = dummyHead;
            ListNode p = dummyHead.next;
            int step = 0;
            while (step < m - 1) {
                g = g.next; p = p.next;
                step ++;
            }
            for (int i = 0; i < n - m; i++) {
                ListNode removed = p.next;
                p.next = p.next.next;
                removed.next = g.next;
                g.next = removed;
            }
            return dummyHead.next;*/
        }
    }
}
