1class Solution {
2    public boolean isBipartite(int[][] g) {
3        int n=g.length;
4        int[] color=new int[n];
5        for(int i=0;i<n;i++){
6            if(color[i]!=0){
7                continue;
8            }
9            Queue<Integer> q=new LinkedList<>();
10            color[i]=1;
11            q.add(i);
12            while(!q.isEmpty()){
13                int node=q.poll();
14                for(int e:g[node]){
15                    if(color[e]==0){
16                        color[e]=3-color[node];
17                        q.add(e);
18                    }
19                    else if(color[e]==color[node]){
20                        return false;
21                        
22                    }
23                }
24            }
25        }
26        return true;
27    }
28}