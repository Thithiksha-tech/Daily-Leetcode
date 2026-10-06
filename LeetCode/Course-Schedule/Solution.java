1class Solution {
2    public boolean canFinish(int n, int[][] pre) {
3   
4        int[] indeg=new int[n];
5        @SuppressWarnings("unchecked")
6        ArrayList<Integer>[] g=new ArrayList[n];
7        for(int i=0;i<n;i++){
8            g[i]=new ArrayList<>();
9        }
10        for(int i=0;i<pre.length;i++){
11            int u=pre[i][1];
12            int v=pre[i][0];
13            g[u].add(v);
14            indeg[v]++;
15        }
16        ArrayList<Integer> topo=new ArrayList<>();
17        Queue<Integer> q=new LinkedList<>();
18        for(int i=0;i<n;i++){
19            if(indeg[i]==0){
20                q.add(i);
21            }
22        }
23        while(!q.isEmpty()){
24            int node=q.poll();
25            topo.add(node);
26            for(int nei:g[node]){
27                int v=nei;
28                indeg[v]--;
29                if(indeg[v]==0){
30                    q.add(v);
31                }
32            }
33        }
34        if(topo.size()==n){
35            return true;
36        }
37        return false;
38        
39    }
40}