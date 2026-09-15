1class Solution {
2    public static boolean isvalid(int row,int col,char[][] board,char ch){
3        for(int i=0;i<9;i++){
4            if(board[i][col]==ch){
5                return false;
6            }
7            if(board[row][i]==ch){
8                return false;
9            }
10            int boxrow=3*(row/3)+i/3;
11            int boxcol=3*(col/3)+i%3;
12            if(board[boxrow][boxcol]==ch){
13                return false;
14            }
15        }
16        return true;
17    }
18    public static boolean solve(char[][] board){
19        for(int i=0;i<board.length;i++){
20            for(int j=0;j<board[0].length;j++){
21                if(board[i][j]=='.'){
22                    for(char ch='1';ch<='9';ch++){
23                        if(isvalid(i,j,board,ch)){
24                            board[i][j]=ch;
25                            if(solve(board)){
26                                return true;
27                            }
28                        }
29                        
30                        board[i][j]='.';
31                        
32                        
33                    }
34                    return false;
35                   
36                }
37                
38            
39                
40            }
41            
42        }
43        return true;
44        
45    }
46    public void solveSudoku(char[][] board) {
47        solve(board);
48        return;
49        
50    }
51}