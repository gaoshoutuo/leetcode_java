package leetcode_41_TO_60;

import java.util.Arrays;

public class Program_43 {//两个小于110位的字符串数字相乘 不能使用bigInteger  hard暂时不挑战了 做做medium好了 都是怪物hard

    public static void main(String []args){
        Solution solution=new Solution();

        System.out.println(solution.multiply("6913259244"
                ,"71103343"));
    }

    /**
     * Runtime: 5 ms, faster than 59.47% of Java online submissions for Multiply Strings.
     * Memory Usage: 36.1 MB, less than 99.94% of Java online submissions for Multiply Strings.
     * Next challenges:  bbffgdbbe dsffdg
     */
    static class Solution {//dg sd sb 本来以为很简单的东西折腾了这么久 坑坑好多啊


        public String multiply(String num1, String num2) {

            //if (num1==null||num2==null  Integer.parseInt(num1)==0||  Integer.parseInt(num2)==0)return "0";
            if (num1==null||num2==null||num1.equals("0")||num2.equals("0"))return "0";
            StringBuilder sb1=new StringBuilder();
            StringBuilder sb2=new StringBuilder();
            char []numArr1= sb1.append(num1).reverse().toString().toCharArray();
            char []numArr2= sb2.append(num2).reverse().toString().toCharArray();
            for (int i=0;i<num1.length()||i<num2.length();i++){
                if (i<num1.length())
                    numArr1[i]= (char) (numArr1[i]-'0');
                if (i<num2.length())
                    numArr2[i]= (char) (numArr2[i]-'0');
            }
            int []res=new int[num1.length()+num2.length()];
            for (int i=0;i<num1.length();i++){
                for (int j=0;j<num2.length();j++){
              /*      res[i+j+1]+= res[i+j]/10;
                    res[i+j]=res[i+j]%10;*/
                    int k=numArr1[i]*numArr2[j];
                    res[i+j+1]= res[i+j+1]+ k/10;
                    res[i+j]= res[i+j]+k%10;
                    res[i+j+1]+=res[i+j]/10;
                    res[i+j]= res[i+j]%10;
                }
            }
            //System.out.println(10%10);
            StringBuilder result=new StringBuilder();
            for (int i=res.length-1;i>=0;i--){
                if (i==res.length-1&&res[i]==0)
                    continue;
                result.append(res[i]);
            }
            return  result.toString();
        }
    }
}
