package leetcode_61_TO_80;

public class Program_79 {//
    /*79. Word Search medium 每个可以用无限次 medium 感觉应该是easy的
    board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
     */
    public static void main(String []args){
        Solution solution=new Solution();
        long l1=System.currentTimeMillis();
        boolean b=solution.existMy(new char[][]{
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','b'},
        },"baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println(b);
        System.out.println(System.currentTimeMillis()-l1);

        boolean c=solution.existMy(new char[][]{{'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'},
        },"ABCB");
        System.out.println(c);

        boolean d=solution.existMy(new char[][]{{'A','A','A','A'},
                {'A','A','A','A'},
                {'A','A','A','A'},
        },"AAAAAAAAAAAAA");
        System.out.println(d);
    }

    static class Solution {//{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}  感觉应该越是回溯解决
        /*public boolean exist(char[][] board, String word) {
            //估计也有不消耗多余空间的办法 或者是排序
            int []kk=new int[52];
            if (board.length==0)return false;
            int row=board.length;int column=board[0].length;
            for (int i=0;i<board.length;i++) {
                for (int j = 0; j < column; j++) {
                    if (board[i][j] >= 'a' && board[i][j] <= 'z') {
                        kk[board[i][j] - 'a']++;
                    } else if (board[i][j] >= 'A' && board[i][j] <= 'Z') {
                        kk[board[i][j] - 'A' + 26]++;
                    }
                }
            }

            char []ww=word.toCharArray();
            for (int i=0;i<word.length();i++){
                if (ww[i]>='a'&&ww[i]<='z'){
                    kk[ ww[i]-'a']--;
                    if (kk[ ww[i]-'a']<0)return false;
                }else if (ww[i]>='A'&&ww[i]<='Z'){
                    kk[ ww[i]-'A'+26]--;
                    if (kk[ ww[i]-'A'+26]<0)return false;
                }
            }
            return true;
        }
    }*/
        boolean abc=false;
        public boolean existMy(char[][] board, String word) {
            //boolean isTrue[][]=new boolean[board.length][board[0].length];
            char[]kk=word.toCharArray();
            for (int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    abc=backTrace(board,kk,i,j,0,new boolean[board.length][board[0].length]);
                    if (abc==true)return true;
                }
            }
            return abc;
        }

        boolean backTrace(char[][] board, char[]word,int i,int j,int k,boolean bb[][]){
            if (i<0 || j<0 || i == board.length || j == board[0].length) return false;
            if (board[i][j]!=word[k]||bb[i][j]==true){
                //bb[i][j]=false;  这才是我自己的解决方案 日了狗啊
                return false;
            }
            bb[i][j]=true;
                System.out.println(board[i][j]+"----"+i+"----"+j+"----"+k);
                if (k==word.length-1){
                    abc=true;
                    return true;
                }
                //board[i][j]^=256;
                boolean exists=backTrace(board,word,i+1,j,k+1,bb)||
                        backTrace(board,word,i-1,j,k+1,bb)||
                        backTrace(board,word,i,j+1,k+1,bb)||
                        backTrace(board,word,i,j-1,k+1,bb);
                //board[i][j]^=256;
            if (exists==false)
            bb[i][j]=false;
               return exists;
            //估计是我爸题意理解错误了  With extra space it will become too slow, say you create one additional 2D visited array now you will also have to initialize again and again.
        }


        public boolean exist(char[][] board, String word) {
            char[] w = word.toCharArray();
            for (int y=0; y<board.length; y++) {
                for (int x=0; x<board[y].length; x++) {
                    if (exist(board, y, x, w, 0)) return true;
                }
            }
            return false;
        }

        private boolean exist(char[][] board, int y, int x, char[] word, int i) {
            if (i == word.length) return true;
            if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
            if (board[y][x] != word[i]) return false;//反向 省无限资源
            board[y][x] ^= 256;
            boolean exist = exist(board, y, x+1, word, i+1)
                    || exist(board, y, x-1, word, i+1)
                    || exist(board, y+1, x, word, i+1)
                    || exist(board, y-1, x, word, i+1);
            board[y][x] ^= 256;
            return exist;
        }



// 我的方法 超时了  看看大神的办法
    }

    /*
    public boolean exist(char[][] board, String word) {
    char[] w = word.toCharArray();
    for (int y=0; y<board.length; y++) {
    	for (int x=0; x<board[y].length; x++) {
    		if (exist(board, y, x, w, 0)) return true;
    	}
    }
    return false;
}

private boolean exist(char[][] board, int y, int x, char[] word, int i) {
	if (i == word.length) return true;
	if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
	if (board[y][x] != word[i]) return false;
	board[y][x] ^= 256;
	boolean exist = exist(board, y, x+1, word, i+1)
		|| exist(board, y, x-1, word, i+1)
		|| exist(board, y+1, x, word, i+1)
		|| exist(board, y-1, x, word, i+1);
	board[y][x] ^= 256;
	return exist;
}
     */
    //我傻了 还有小数 果然没那么简单


}
