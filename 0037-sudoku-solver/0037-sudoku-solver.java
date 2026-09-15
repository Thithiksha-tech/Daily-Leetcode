class Solution {
    public static boolean isvalid(int row,int col,char[][] board,char ch){
        for(int i=0;i<9;i++){
            if(board[i][col]==ch){
                return false;
            }
            if(board[row][i]==ch){
                return false;
            }
            int boxrow=3*(row/3)+i/3;
            int boxcol=3*(col/3)+i%3;
            if(board[boxrow][boxcol]==ch){
                return false;
            }
        }
        return true;
    }
    public static boolean solve(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    for(char ch='1';ch<='9';ch++){
                        if(isvalid(i,j,board,ch)){
                            board[i][j]=ch;
                            if(solve(board)){
                                return true;
                            }
                        }
                        
                        board[i][j]='.';
                        
                        
                    }
                    return false;
                   
                }
                
            
                
            }
            
        }
        return true;
        
    }
    public void solveSudoku(char[][] board) {
        solve(board);
        return;
        
    }
}