1class Solution {
2    public int networkDelayTime(int[][] times, int n, int k) {
3        //topological sort
4        ArrayList<int[]>[] g=new ArrayList[n+1];
5        
6        for(int i=1;i<=n;i++){
7            g[i]=new ArrayList<>();
8
9        }
10        for(int[] e:times){
11            int u=e[0];
12            int v=e[1];
13            int w=e[2];
14            g[u].add(new int[]{v,w});
15        }
16        int[] dist=new int[n+1];
17        Arrays.fill(dist,Integer.MAX_VALUE);
18        dist[k]=0;
19        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
20        pq.offer(new int[]{k,0});
21        while(!pq.isEmpty()){
22            int[] cur=pq.poll();
23            int u=cur[0];
24            int curdist=cur[1];
25            if(curdist>dist[u]){
26                continue;
27            }
28            for(int[] e:g[u]){
29                int v=e[0];
30                int w=e[1];
31                if(dist[u]+w<dist[v]){
32                    dist[v]=dist[u]+w;
33                    pq.offer(new int[]{v,dist[v]});
34                }
35                
36            }
37
38        }
39        int ans=0;
40        for(int i=1;i<=n;i++){
41            if(dist[i]==Integer.MAX_VALUE){
42                return -1;
43            }
44            ans=Math.max(ans,dist[i]);
45        }
46        return ans;
47        
48    }
49}