package leetcode_81_TO_100;

public class Program_83 {
    /*
    83. Remove Duplicates from Sorted List easy
    这个要自己了
    Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
     */


      //Definition for singly-linked list.
      public static void main(String []args){
          Solution solution=new Solution();
          int []o=new int[]{1,1};
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
      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    static class Solution {

          //Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
          //Memory Usage: 39.5 MB, less than 7.14% of Java online submissions for Remove Duplicates from Sorted List.
        // 前后不到一分钟就做出来了
        public ListNode deleteDuplicates(ListNode head) {
            if (head==null)return null;
            ListNode p=new ListNode(Integer.MIN_VALUE);
            ListNode pCopy=new ListNode(Integer.MIN_VALUE);
            ListNode pCopy2=pCopy;
            p.next=head;
            ListNode pNext=p.next;
            while (pNext!=null){
                if (!checkVal(p.val,pNext.val)){
                    pCopy.next=new ListNode(pNext.val);
                    pCopy=pCopy.next;
                }
                p=p.next;
                pNext=pNext.next;
            }
            return pCopy2.next;
        }
        boolean checkVal(int t1,int t2){
            return t1==t2;
        }
    }
}
