class Solution {
    public int countPaths(int n, int[][] roads) {
        long[] dist=new long[n];
        @SuppressWarnings("unchecked")
        ArrayList<long[]>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int w=roads[i][2];
            graph[u].add(new long[]{v,w});
            graph[v].add(new long[]{u,w});

        }
        int MOD=1000000007;
        long countmin=Long.MAX_VALUE;
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        pq.add(new long[]{0,0});
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        long count=0;
        long[] ways=new long[n];
        ways[0]=1;
        while(!pq.isEmpty()){
            long[] cur=pq.poll();
            int u=(int)cur[0];
            long w=cur[1];
            if(w>dist[u]){
                continue;
            }
            
            for(long[] edge:graph[u]){
                int v=(int)edge[0];
                long we=edge[1];
                if(dist[u]+we<dist[v]){
                    dist[v]=dist[u]+we;
                    pq.add(new long[]{v,dist[v]});
                    ways[v]=ways[u];
                }
                else if(dist[u]+we==dist[v]){
                    ways[v]=(ways[v]+ways[u])%MOD;
                }
            }

        }
        int val=(int)(ways[n-1]);
        return val;

        
    }
}