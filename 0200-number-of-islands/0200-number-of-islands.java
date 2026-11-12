class Solution {
    public static void dfs(int x,int y,char[][] grid,int n,int m,boolean[][] vis){
        if(x<0||x>=n||y<0||y>=m||vis[x][y]||grid[x][y]=='0'){
            return;
        }
        vis[x][y]=true;
        dfs(x+1,y,grid,n,m,vis);
        dfs(x,y+1,grid,n,m,vis);
        dfs(x-1,y,grid,n,m,vis);
        dfs(x,y-1,grid,n,m,vis);

        
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
            if(grid[i][j]=='1'&&!vis[i][j]){
                dfs(i,j,grid,n,m,vis);
                count++;
            }
            
        }
        return count;
        
        
    }
}
