package leetcode_21_TO_40;
//会议起来了这道题是当年的pat题目 count and say 1<n<30

/**
 * Runtime: 1 ms, faster than 98.89% of Java online submissions for Count and Say.
 * Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Count and Say.
 */
public class Program_38 {

    public static void main(String []args){
        Solution solution=new Solution();

        System.out.println(solution.countAndSay(5));
       // solution.countAndSay(4);
    }
//思路 要么30个圈算出来  要么按着算  第二种吧 速度快一点
    static class Solution {
        public String countAndSay(int n) {
           // String []dd=new String[35];
            String dd[]=new String[40];
            if (n==0)return null;
            if (n==1)return "1";
            if (n==2)return "11";
          int k=0;dd[2]="11";
       do{
          String str2= getSolution(dd[2+k]);
           //System.out.println(str2);
           dd[3+k]=str2;
           k++;
           n--;
       }while (n-2>0);

            return dd[n+k];
        }
        public String getSolution(String str){
            StringBuilder stringBuilder=new StringBuilder();
            //System.out.println(str);
            char abc[]=str.toCharArray();
            //System.out.println(abc[0]);
            int count=0;
            for(int i=1;i<abc.length;i++){
                if (abc[i]==abc[i-1]){
                    count++;
                    if (i==abc.length-1){
                        stringBuilder.append(count+1).append(abc[i-1]);
                        return stringBuilder.toString();
                    }

                }
                else {
                    stringBuilder.append(count+1).append(abc[i-1]);
                    count=0;
                    if (i==abc.length-1){
                        stringBuilder.append(1).append(abc[i]);
                        return stringBuilder.toString();
                    }
                }
            }
            return null;
        }
    }
}
