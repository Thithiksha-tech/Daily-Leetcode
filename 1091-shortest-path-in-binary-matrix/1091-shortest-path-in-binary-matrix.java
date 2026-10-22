class Solution {
    static int[] dx={-1,-1,-1,0,0,1,1,1};
    static int[] dy={-1,0,1,-1,1,-1,0,1};
    public static int bfs(int x,int y,int[][] grid,int n,int m){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y});
        int[][] dist=new int[n][m];
        dist[0][0]=1;
        while(!q.isEmpty()){
            int[] node=q.poll();
            int r=node[0];
            int c=node[1];
            
            if(r==n-1&&c==m-1){
                return dist[r][c];
            }
           
            for(int i=0;i<8;i++){
                int nx=r+dx[i];
                int ny=c+dy[i];
                
                if(nx>=0&&nx<n&&ny>=0&&ny<m){
                    if(grid[nx][ny]==0){
                        dist[nx][ny]=dist[r][c]+1;
                        grid[nx][ny]=1;
                        q.add(new int[]{nx,ny});
                    }
                    
                }
            }
        }
        return -1;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1){
            return -1;
        }
        return bfs(0,0,grid,grid.length,grid[0].length);
        
    }
}