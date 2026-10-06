1class Solution {
2    static int[] dx={-1,1,0,0};
3    static int[] dy={0,0,-1,1};
4    public static void dfs(char[][] grid,boolean[][] vis,int x,int y,int n,int m){
5        vis[x][y]=true;
6        for(int i=0;i<4;i++){
7            int nx=x+dx[i];
8            int ny=y+dy[i];
9            if(nx>=0&&nx<n&&ny>=0&&ny<m){
10                
11                if(!vis[nx][ny]&&grid[nx][ny]=='1'){
12                    grid[nx][ny]='0';
13                    dfs(grid,vis,nx,ny,n,m);
14                }
15            }
16        }
17    }
18    public int numIslands(char[][] grid) {
19        int n=grid.length;
20        int m=grid[0].length;
21        boolean[][] vis=new boolean[n][m];
22        int count=0;
23        for(int i=0;i<n;i++){
24            for(int j=0;j<m;j++){
25                if(!vis[i][j]&&grid[i][j]=='1'){
26                    count++;
27                    dfs(grid,vis,i,j,n,m);
28                }
29            }
30        }
31        return count;
32    }
33}