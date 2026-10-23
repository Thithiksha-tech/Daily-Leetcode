class Solution {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    public int nearestExit(char[][] maze, int[] et) {
        //use dist array
        int x=et[0];
        int y=et[1];
        int n=maze.length;
        int m=maze[0].length;
        boolean[][] vis=new boolean[n][m];
        vis[x][y]=true;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y});
      
        int[][] dist=new int[n][m];
        while(!q.isEmpty()){
            int[] node=q.poll();
            int r=node[0];
            int c=node[1];
            if((r==0)||(c==0)||(r==n-1)||(c==m-1)){
                if(maze[r][c]=='.'&&(r!=x||c!=y)){
                    return dist[r][c];
                }
            }
            for(int i=0;i<4;i++){
                int nx=r+dx[i];
                int ny=c+dy[i];
                if(nx>=0&&nx<n&&ny>=0&&ny<m){
                    if(maze[nx][ny]=='.'&&!(vis[nx][ny])){
                        dist[nx][ny]=dist[r][c]+1;
                        q.add(new int[]{nx,ny});
                        vis[nx][ny]=true;
                        
                    }
                    
                }
            }
        }
        return -1; 
    }
}