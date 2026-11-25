class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int p=flights[i][2];
            g.get(u).add(new int[]{v,p});

        }
        Queue<int[]> pq=new LinkedList<>();
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        pq.add(new int[]{src,0,0});
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int node=cur[0];
            int cost=cur[1];
            int steps=cur[2];
            
            if(steps>k){
                continue;
            }
            for(int[] x:g.get(node)){
                int nei=x[0];
                int w=x[1];
                int nprice=cost+x[1];
                if(dist[nei]>nprice){
                    dist[nei]=nprice;
                    pq.add(new int[]{nei,nprice,steps+1});
                }
            }
            

        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
        
    }
}