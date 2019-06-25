package leetcode_21_TO_40;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program_36 {
    public static void main(String []args){
        Solution solution=new Solution();
        char [][]abc= new char[9][9];
        abc[0]= new char[]{'5', '3','.', '.', '.', '.', '.', '.', '.'};
        abc[1]= new char[]{'6', '.','.', '1', '9', '5', '.', '.', '.'};
        abc[2]= new char[]{'.', '9','8', '.', '.', '.', '.', '6', '.'};
        abc[3]= new char[]{'8', '.','.', '.', '6', '.', '.', '.', '3'};
        abc[4]= new char[]{'4', '.','.', '8', '.', '3', '.', '.', '1'};
        abc[5]= new char[]{'7', '.','.', '.', '2', '.', '.', '.', '6'};
        abc[6]= new char[]{'.', '6','.', '.', '.', '.', '2', '8', '.'};
        abc[7]= new char[]{'.', '.','.', '4', '1', '9', '.', '.', '5'};
        abc[8]= new char[]{'.', '.','.', '.', '8', '.', '.', '7', '9'};
        System.out.println(solution.isValidSudoku(abc));
    }

}

class Solution {//检查一个缺省的数独是否是一个有效数独 行列九宫
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set=new HashSet<>();
        if (board==null)return false;
        //行
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (board[i][j]!='.'){
                    boolean yes=set.add(board[i][j]);
                    if (yes==false){
                        //System.out.println(1);
                        return false;
                    }
                }
            }
            set.clear();
        }
        //列
        for (int j=0;j<9;j++){
            for (int i=0;i<9;i++){
                if (board[i][j]!='.'){
                    boolean yes=set.add(board[i][j]);
                    if (yes==false){
                       // System.out.println(2);
                        return false;
                    }
                }
            }
            set.clear();
        }
        set.clear();
        //九宫
        for (int i=0;i<9;i=i+3){
            for (int j=0;j<9;j=j+3) {
                for (int k=0;k<3;k++){
                    for (int l=0;l<3;l++){
                        if (board[i+k][j+l]!='.'){
                            boolean yes=set.add(board[i+k][j+l]);
                            //System.out.println(k+"dd"+l);
                            if (yes==false){
                                //System.out.println(board[i+k][j+l]);
                                return false;
                            }
                        }
                    }
                }
                set.clear();
            }

            }
        return true;
    }
}
