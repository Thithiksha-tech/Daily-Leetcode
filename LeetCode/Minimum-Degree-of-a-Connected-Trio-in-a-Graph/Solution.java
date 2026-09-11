1class Solution {
2    public int minTrioDegree(int n, int[][] edges) {
3        int[][] g=new int[n+1][n+1];
4        int[] deg=new int[n+1];
5
6        for(int[] e:edges){
7            int u=e[0];
8            int v=e[1];
9            g[u][v]=1;
10            g[v][u]=1;
11            deg[u]++;
12            deg[v]++;
13
14
15        }
16        int mintrios=Integer.MAX_VALUE;
17        for(int i=1;i<=n;i++){
18            for(int j=i+1;j<=n;j++){
19                for(int k=j+1;k<=n;k++){
20                    int degree=0;
21                    if(g[i][j]==1&&g[j][k]==1&&g[i][k]==1){
22                        degree=deg[i]+deg[j]+deg[k]-6;
23                        mintrios=Math.min(mintrios,degree);
24
25                    }
26                }
27            }
28        }
29        if(mintrios==Integer.MAX_VALUE){
30            return -1;
31        }
32        return mintrios;
33        
34    }
35}