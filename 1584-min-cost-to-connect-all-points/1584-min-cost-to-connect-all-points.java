class Solution {
    public static int manhat(int x,int y,int nx,int ny){
        return Math.abs(x-nx)+Math.abs(y-ny);
    }
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        int n=points.length;
        pq.add(new int[]{0,0});
        int costvalue=0;
        boolean[] vis=new boolean[n];
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int node=cur[0];
            int cost=cur[1];
            if(vis[node]){
                continue;
            }
            costvalue+=cost;
            vis[node]=true;
            for(int i=0;i<n;i++){
                int dist=manhat(points[node][0],points[node][1],points[i][0],points[i][1]);
                if(!vis[i]){
                    pq.add(new int[]{i,dist});
                }
            }
            
            

        }
        return costvalue;

        
    }
}