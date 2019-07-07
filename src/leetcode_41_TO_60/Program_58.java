package leetcode_41_TO_60;

public class Program_58 {//58. Length of Last Word 最后单词长度Input: "Hello World" Output: 5

    public static void main(String []args){
        Solution solution=new Solution();
        System.out.println(solution.lengthOfLastWord("  "));
    }

    static class Solution {
        public int lengthOfLastWord(String s) {
            if (s.length()==0||s.equals(" "))return 0;
            String[] st=s.split(" ");
            if (st.length==0)return 0;
            return st[st.length-1].length();
        }
    }
    /**
     * Runtime: 1 ms, faster than 46.26% of Java online submissions for Length of Last Word.
     * Memory Usage: 35.7 MB, less than 99.96% of Java online submissions for Length of Last Word.
     */
}
