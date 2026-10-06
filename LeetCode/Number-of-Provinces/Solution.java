1class Solution {
2    public static void dfs(ArrayList<Integer>[] g,boolean[] vis,int node){
3        vis[node]=true;
4        for(int nei:g[node]){
5            if(!vis[nei]){
6                dfs(g,vis,nei);
7            }
8        }
9    }
10    public int findCircleNum(int[][] c) {
11        int n=c.length;
12
13        ArrayList<Integer>[] g=new ArrayList[n+1];
14        for(int i=1;i<=n;i++){
15            g[i]=new ArrayList<>();
16        }
17        for(int i=1;i<=n;i++){
18            for(int j=1;j<=n;j++){
19                if(c[i-1][j-1]==1){
20                    g[i].add(j);
21                }
22            }
23        }
24        int count=0;
25        boolean[] vis=new boolean[n+1];
26        for(int i=1;i<=n;i++){
27            if(!vis[i]){
28                count++;
29                dfs(g,vis,i);
30            }
31        }
32        return count;
33        
34    }
35}