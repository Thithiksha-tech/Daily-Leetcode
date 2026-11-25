class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> f=new ArrayList<>();
        for(int i=0;i<n;i++){
            f.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int p=flights[i][2];
            f.get(u).add(new int[]{v,p});
        }
        Queue<int[]> pq=new LinkedList<>();
        //from where to how much and what are its number of steps
        pq.add(new int[]{src,0,0});
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int v=cur[0];
            int cost=cur[1];
            int steps=cur[2];
            
            if(steps>k){
                continue;
            }
            for(int[] ch:f.get(v)){
                int nei=ch[0];
                int c=ch[1];
                int nprice=cost+c;
                if(nprice<dist[nei]){
                    dist[nei]=nprice;
                    pq.add(new int[]{nei,nprice,steps+1});
                }
            }
            
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
        
        
    }
}