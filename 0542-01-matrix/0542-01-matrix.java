class Solution {
    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};

    public static int[][] bfs(int[][] mat,int n,int m){
        Queue<int[]> q=new LinkedList<>();
       
        int[][] dist=new int[n][m];
        for(int k=0;k<dist.length;k++){
            Arrays.fill(dist[k],-1);
            
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    dist[i][j]=0;
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int size=q.size();
            for(int k=0;k<size;k++){
                int[] node=q.poll();
                int r=node[0];
                int c=node[1];
                for(int i=0;i<4;i++){
                    int nx=r+dx[i];
                    int ny=c+dy[i];
                    if(nx>=0&&nx<n&&ny>=0&&ny<m&&dist[nx][ny]==-1){
                       dist[nx][ny]=dist[r][c]+1;
                        q.add(new int[]{nx,ny});
                        
                    }
                }
               

            }
            
        }
        return dist;

    }
    public int[][] updateMatrix(int[][] mat) {
        return bfs(mat,mat.length,mat[0].length);

        
    }
}