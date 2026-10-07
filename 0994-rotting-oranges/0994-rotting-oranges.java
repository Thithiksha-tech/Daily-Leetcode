class Solution {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    public static int solve(Queue<int[]> q,int[][] grid,int n,int m,int fresh){
        int min=0;
        while(!q.isEmpty()&&fresh>0){
            int size=q.size();
            for(int k=0;k<size;k++){
                int[] curr=q.poll();
                int x=curr[0];
                int y=curr[1];
                
                for(int i=0;i<4;i++){
                    int nx=x+dx[i];
                    int ny=y+dy[i];
                    if(nx>=0&&nx<n&&ny>=0&&ny<m){
                        if(grid[nx][ny]==1){
                            grid[nx][ny]=2;
                            fresh--;
                            q.add(new int[]{nx,ny});
                        }
                    }

                }

            }
            min++;
        }
        return fresh==0?min:-1;

    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
    
        int fresh=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
     
        
   
        return solve(q,grid,n,m,fresh);

        
    }
}