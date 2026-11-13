class Solution {
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    public static int bfs(int[][] grid,boolean[][] vis,Queue<int[]> q,int n,int m,int[][] dist){
        q.add(new int[]{0,0});
        vis[0][0]=true;
        dist[0][0]=1;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int x=cur[0];
            int y=cur[1];
            if(x==n-1&&y==m-1){
                return dist[x][y];
            }
            for(int i=0;i<8;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx>=0&&nx<n&&ny>=0&&ny<m&&!vis[nx][ny]&&grid[nx][ny]!=1){
                    q.add(new int[]{nx,ny});
                    dist[nx][ny]=dist[x][y]+1;
                    vis[nx][ny]=true;

                }
            }

        }
        return -1;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(grid[0][0]==1){
            return -1;
        }
        boolean[][] vis=new boolean[n][n];
        Queue<int[]> q=new LinkedList<>();
        int[][] dist=new int[n][n];
        return bfs(grid,vis,q,n,m,dist);
        

    }
}