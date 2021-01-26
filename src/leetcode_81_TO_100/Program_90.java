package leetcode_81_TO_100;

import java.util.*;

public class Program_90 {
    /*
    90. Subsets II  medium 重复元素数组求集合
    Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
     */
    public static void main(String []args){
        Solution solution=new Solution();
        List<List<Integer>>lists=solution.subsetsWithDup(new int[]{4,4,4,1,4});
        System.out.println(lists);
     /*   Set<ArrayList<Integer>>set=new HashSet<>();
        ArrayList l1=new ArrayList();
        ArrayList l2=new ArrayList();
        l1.add(1);l1.add(2);
        l2.add(2);l2.add(1);
        set.add(l1);set.add(l2);
        System.out.println(set);*/
    }
    static class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
           List<List<Integer>> lists=new ArrayList<>();
            List<Integer> list=new ArrayList<>();
            for (int i=0;i<=nums.length;i++)
                backTrace(lists,list,nums,0,i);
            // backTrace(lists,list,nums,0,nums.length);

            return lists;
        }
        void backTrace( List<List<Integer>> lists, List<Integer> list,int[] nums,int start,int k){
            if (list.size()==k){
               /* list.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if (o1>o2){
                            return 1;
                        }else if (o1==o2){
                            return 0;
                        }else {
                            return -1;
                        }

                    }
                });*/
                if (!lists.contains(list)){
                    lists.add(new ArrayList<>(list));
                }
                return;
            }
            for (int i=start;i<nums.length;i++){
                list.add(nums[i]);
                backTrace(lists,list,nums,i+1,k);
                if (list.size()>0)
                    list.remove(list.size()-1);
            }
        }
//Runtime: 13 ms, faster than 6.40% of Java online submissions for Subsets II.
//Memory Usage: 39.8 MB, less than 5.88% of Java online submissions for Subsets II.
        //耻辱啊 这怎么快 contains 不能瞎逼用

    }
}
