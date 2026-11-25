class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int m=times.length;
        @SuppressWarnings("unchecked")
        ArrayList<int[]>[] g=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            g[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
            g[u].add(new int[]{v,w});
        }
        
        int[] dist=new int[n+1];
        for(int i=1;i<=n;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        Queue<Integer> q=new LinkedList<>();
        

        dist[k]=0;
       q.add(k);
       
       while(!q.isEmpty()){
            int u=q.poll();
            
            for(int[] x:g[u]){
                int v=x[0];
                int w=x[1];
                if(dist[u]+w<dist[v]){
                    dist[v]=dist[u]+w;
                    q.add(v);
                }
            }
                
            
       }
       int max=0;
       for(int i=1;i<=n;i++){
        if(dist[i]==Integer.MAX_VALUE){
            return -1;
        }
        max=Math.max(max,dist[i]);
       }
       return max;
       
        
    }
}