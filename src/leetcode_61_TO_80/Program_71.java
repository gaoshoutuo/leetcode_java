package leetcode_61_TO_80;

import java.util.ArrayList;

public class Program_71 {//p
    /*
    71. Simplify Path medium
    Input: "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.

Input: "/a//b////c/d//././/.."
Output: "/a/b/c"

思路
1 从左向右 斜杠分割 每次斜杠后小数
2 .要跟前点呼应 如果是 则退一个 不是则继续
3
     */

    public static void main(String []args){
        Solution solution=new Solution();
        System.out.println(solution.simplifyPath("/home/../../.."));
        //System.out.println(solution.simplifyPath("/a//b////c/d//././/.."));
    }

    static class Solution {
        public String simplifyPath(String path) {
            char[]abc=(path+"/").toCharArray();
            ArrayList<String>list=new ArrayList<>();
            StringBuilder sb=new StringBuilder();
            int m=0;
            for (int i=0;i<abc.length;i++){
                if (abc[i]=='/'){
                    m=1;
                    if (sb.toString().length()==0){
                    }else {
                        //System.out.println('/'+sb.toString());
                        if (sb.toString().equals("..")){
                            if (list.size()!=0){
                                list.remove(list.size()-1);
                            }
                            sb=new StringBuilder();
                        }else if (sb.toString().equals(".")){
                            sb=new StringBuilder();
                        }else {
                            list.add('/'+sb.toString());
                            sb=new StringBuilder();
                        }

                    }
               }else if (abc[i]!='/'&&abc[i]!='.'){
                    if (m==1)
                        sb.append(abc[i]);
                }else if (abc[i]=='.'){
                    if (i==0)continue;
                    sb.append('.');
                    /*if (abc[i-1]=='.'){
                    }*/
                }
            }
            if (list.size()==0)return "/";
            StringBuilder sb2=new StringBuilder();
            for (int i=0;i<list.size();i++){
                sb2.append(list.get(i));
            }
            return sb2.toString();
        }
        /**
         * Runtime: 3 ms, faster than 96.49% of Java online submissions for Simplify Path.
         * Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for Simplify Path.
         *  我比他更快 但是stack以及sprit 的方法我应该早应该想到的
         */
    }

    /**
     Runtime: 6 ms, faster than 40.85% of Java online submissions for Simplify Path.
     Memory Usage: 37.6 MB, less than 86.67% of Java online submissions for Simplify Path.
     public String simplifyPath(String path) {
     Deque<String> stack = new LinkedList<>();
     Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
     for (String dir : path.split("/")) {
     if (dir.equals("..") && !stack.isEmpty()) stack.pop();
     else if (!skip.contains(dir)) stack.push(dir);
     }
     String res = "";
     for (String dir : stack) res = "/" + dir + res;
     return res.isEmpty() ? "/" : res;
     }
     */
}
