class Solution {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    public static int bfs(char[][] grid,int x,int y,int n,int m,boolean[][] vis,Queue<int[]> q,int[][] dist,int[] e){
        vis[x][y]=true;
        q.add(new int[]{x,y});
        dist[0][0]=0;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int sx=cur[0];
            int sy=cur[1];

            if((sx!=e[0]||sy!=e[1])&&(sx==0||sx==n-1||sy==0||sy==m-1)){
                return dist[sx][sy];
            }
            for(int i=0;i<4;i++){
                int nx=dx[i]+sx;
                int ny=dy[i]+sy;
                if(nx>=0&&nx<n&&ny>=0&&ny<m&&!vis[nx][ny]&&grid[nx][ny]!='+'){
                    q.add(new int[]{nx,ny});
                    vis[nx][ny]=true;
                    dist[nx][ny]=dist[sx][sy]+1;
                }
            }
        }
        return -1;
    }
    public int nearestExit(char[][] grid, int[] e) {
        int n=grid.length;
        int m=grid[0].length;

        boolean[][] vis=new boolean[n+1][m+1];
        int[][] dist=new int[n+1][m+1];
        Queue<int[]> q=new LinkedList<>();
        int x=e[0];
        int y=e[1];
        return bfs(grid,x,y,n,m,vis,q,dist,e);
        
    }
}