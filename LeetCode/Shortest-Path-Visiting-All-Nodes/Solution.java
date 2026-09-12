1class Solution {
2    public int shortestPathLength(int[][] graph) {
3        int n=graph.length;
4        boolean[][] vis=new boolean[n][1<<n];
5        Queue<int[]> q=new LinkedList<>();
6        for(int i=0;i<n;i++){
7            int mask=1<<i;
8            q.add(new int[]{i,mask});
9            vis[i][mask]=true;
10
11        }
12        int steps=0;
13        int all=(1<<n)-1;
14        while(!q.isEmpty()){
15            int size=q.size();
16            for(int i=0;i<size;i++){
17                int[] cur=q.remove();
18                int node=cur[0];
19                int mask=cur[1];
20                if(mask==all){
21                    return steps;
22                }
23                for(int next:graph[node]){
24                    int newmask=mask|(1<<next);
25                    if(!vis[next][newmask]){
26                        vis[next][newmask]=true;
27                        q.add(new int[]{next,newmask});
28                    }
29                }
30           
31            }
32            steps++;
33        }
34        return -1;
35
36        
37    }
38}