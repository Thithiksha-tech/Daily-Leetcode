1class Solution {
2    static boolean[][] vis;
3    public static boolean dfs(char[][] board,int x,int y,int ind,String word){
4        if(ind==word.length()){
5            return true;
6        }
7        if(x<0||x>=board.length||y<0||y>=board[0].length){
8            return false;
9        }
10        if(vis[x][y]){
11            return false;
12        }
13        if(board[x][y]!=word.charAt(ind)){
14            return false;
15        }
16        vis[x][y]=true;
17        boolean f=dfs(board,x+1,y,ind+1,word)||dfs(board,x-1,y,ind+1,word)||dfs(board,x,y-1,ind+1,word)||dfs(board,x,y+1,ind+1,word);
18        vis[x][y]=false;
19        return f;
20
21    }
22    public boolean exist(char[][] board, String word) {
23        int rows=board.length;
24        int col=board[0].length;
25        vis=new boolean[rows][col];
26        for(int i=0;i<rows;i++){
27            for(int j=0;j<col;j++){
28                if(dfs(board,i,j,0,word)){
29                    return true;
30                }
31            }
32        }
33        return false;
34        
35    }
36
37}