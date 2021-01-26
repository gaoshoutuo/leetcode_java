package leetcode_81_TO_100;

import java.util.ArrayList;
import java.util.List;

public class Program_93 {//medium IP补全 DFS DP？ DFS找所有的可能性的问题 前面的dp
    //wo zen me jiu xie bu chu lai ne
    //多多练习就能写出来了  practice make perfect4
    /*
 执行用时：
6 ms
, 在所有 Java 提交中击败了
35.83%
的用户
内存消耗：
38.5 MB
, 在所有 Java 提交中击败了
56.69%
的用户
     */

    public static void main(String args[]){
        Solution solution=new Solution();
        System.out.println(solution.restoreIpAddresses("25525211135"));
    }
    static class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String>list=new ArrayList<>();
            if (s.length()>12)return null;
            dfs(s,list,0,"",0);
            return list;
        }

        void dfs(String s, List<String> list, int pos, String res, int count){
            //System.out.println(res);
            if (count==4&&pos==s.length()){
                list.add(res);return;
            }
            if(count>=4)return;//过滤保证
            for (int i=1;i<=3;i++){
                if(pos + i > s.length()) break;
                String temp=s.substring(pos,pos+i);
                if((temp.length() > 1 && temp.startsWith("0") )|| Integer.parseInt(temp) >= 256)  break;//&& 优先级大于  || 最低优先级  但是括号加一下没问题
                dfs(s, list, pos + i, count == 0 ? temp : res + "." + temp, count + 1);//for循环保证dfs的持续
            }
        }
    }
}
