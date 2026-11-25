class Solution {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int[][] dist=new int[n][m];
        for(int[] x:dist){
            Arrays.fill(x,Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,0});
        dist[0][0]=0;
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int x=cur[0];
            int y=cur[1];
            int eff=cur[2];
            if(x==n-1&&y==m-1){
                return eff;
            }
            if(eff>dist[x][y]){
                continue;
            }
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                
                if(nx>=0&&nx<n&&ny>=0&&ny<m){
                    int newcost=Math.abs(heights[x][y]-heights[nx][ny]);
                    int maxeff=Math.max(newcost,eff);
                    
                    if(dist[nx][ny]>maxeff){
                        dist[nx][ny]=maxeff;
                        pq.add(new int[]{nx,ny,maxeff});
                    }
                }
            }
        }
        return -1;
        
        
    }
}