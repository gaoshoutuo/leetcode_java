package leetcode_81_TO_100;

public class Program_82 {
    /*
    82. Remove Duplicates from Sorted List II medium
    Input: 1->2->3->3->4->4->5
Output: 1->2->5

Input: 1->1->1->2->3
Output: 2->3

好狠自己也不要
     */
    public static void main(String []args){
        Solution solution=new Solution();
        int []o=new int[]{2,2,3,3,4,5};
        ListNode head=new ListNode(1);
        ListNode Rhead=head;
        for (int i=0;i<o.length;i++){
            head.next=new ListNode(o[i]);
            head=head.next;
        }

        ListNode result=solution.deleteDuplicates(Rhead);
        while (result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }

     // Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    static class Solution {


        public ListNode deleteDuplicates(ListNode head) {
            //Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List II.
            //Memory Usage: 39.3 MB, less than 6.98% of Java online submissions for Remove Duplicates from Sorted List II.
             //这是我自己的解决办法
            if (head==null)return null;
            ListNode p=new ListNode(Integer.MIN_VALUE);
            ListNode pCopy=new ListNode(Integer.MIN_VALUE);
            ListNode pCopy2=pCopy;
            p.next=head;
            ListNode pNext=head;
            while (pNext!=null){
                if (pNext.next!=null){ //System.out.println(pNext.val+"---");
                    if (!checkVal(p.val,pNext.val)&&!checkVal(pNext.val,pNext.next.val)){
                        //pCopy.next=pNext;//这个只有此时的pnext
                        pCopy.next=new ListNode(pNext.val);
                        pCopy=pCopy.next;
                        //pCopy=pNext;
                    }
                        p=pNext;
                        pNext=pNext.next;
                    //三方情况
                }else {
                    if(!checkVal(p.val,pNext.val)){
                        pCopy.next=pNext;
                    }
                    pNext=pNext.next;
                    //两方
                }
            }

            return pCopy2.next;
        }
        boolean checkVal(int t1,int t2){
            return t1==t2;
        }
    }
}
