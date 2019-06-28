package leetcode_41_TO_60;

import java.util.*;

public class Program_49 {//anagrams 相同单词的逆序找到这些总类 丧心病狂 github也墙 vpn也上不去

    //我的思路是把str转化成char数组 然后在一个数组里面++ 数组对比 然后 归并
    //但是在discuss的答主更好，因为他的方法在转化成char之后 sort 然后在转化回str 在map<str,strList>这里面添加相同的，最后
    //map.value转化成listlist
    public static void main(String []args){
        Solution solution=new Solution();
        System.out.println(  solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

    }
    static class Solution {
        /*
        Runtime: 9 ms, faster than 78.63% of Java online submissions for Group Anagrams.
Memory Usage: 40.6 MB, less than 98.85% of Java online submissions for Group Anagrams.
         */


        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
            Map<String,List<String>> map=new HashMap<>();
            int n=strs.length;
            for (int i=0;i<n;i++){
                char []strC=strs[i].toCharArray();
                Arrays.sort(strC);
                String newStr=String.valueOf(strC);
                if (map.containsKey(newStr))map.get(newStr).add(strs[i]);
                else{
                    map.put(newStr,new ArrayList<>());
                    map.get(newStr).add(strs[i]);
                }
              /*  if (!map.containsKey(newStr)) map.put(newStr, new ArrayList<String>());
                map.get(newStr).add(strs[i]);*/

            }
            List<List<String>> lists=new ArrayList<>(map.values());
            return lists;
        }
    }
}
