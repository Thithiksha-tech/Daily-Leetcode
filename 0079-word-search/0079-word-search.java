class Solution {
    static boolean[][] vis;
    public static boolean dfs(char[][] board,int x,int y,int ind,String word){
        if(ind==word.length()){
            return true;
        }
        if(x<0||x>=board.length||y<0||y>=board[0].length){
            return false;
        }
        if(vis[x][y]){
            return false;
        }
        if(board[x][y]!=word.charAt(ind)){
            return false;
        }
        vis[x][y]=true;
        boolean f=dfs(board,x+1,y,ind+1,word)||dfs(board,x-1,y,ind+1,word)||dfs(board,x,y-1,ind+1,word)||dfs(board,x,y+1,ind+1,word);
        vis[x][y]=false;
        return f;

    }
    public boolean exist(char[][] board, String word) {
        int rows=board.length;
        int col=board[0].length;
        vis=new boolean[rows][col];
        for(int i=0;i<rows;i++){
            for(int j=0;j<col;j++){
                if(dfs(board,i,j,0,word)){
                    return true;
                }
            }
        }
        return false;
        
    }

}