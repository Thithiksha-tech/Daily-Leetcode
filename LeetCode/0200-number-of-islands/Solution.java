class Solution {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    public static int bfs(char[][] grid,int x,int y,int n,Queue<int[]> q){
        q.add(new int[]{x,y});
        while(!q.isEmpty()){
            int[] node=q.poll();
            int r=node[0];
            int c=node[1];
            for(int i=0;i<4;i++){
                int nx=r+dx[i];
                int ny=c+dy[i];
                if(nx>=0&&nx<grid.length&&ny>=0&&ny<grid[0].length&&grid[nx][ny]=='1'){
                    grid[nx][ny]='0';
                    q.add(new int[]{nx,ny});
                }
            }

        }
        return 1;
    }
    public int numIslands(char[][] grid) {
        int count=0;
        int n=grid.length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count+=bfs(grid,i,j,n,q);
                    
                }
            }
        }
        return count;
        
    }
}