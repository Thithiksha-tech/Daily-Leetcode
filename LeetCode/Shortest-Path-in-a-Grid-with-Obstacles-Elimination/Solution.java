1class Solution {
2    static int[] dx={-1,1,0,0};
3    static int[] dy={0,0,-1,1};
4    
5    static class state{
6        int r;
7        int c;
8        int rk;
9        state(int r,int c,int rk){
10            this.r=r;
11            this.c=c;
12            this.rk=rk;
13        }
14    }
15    public static int solve(int[][] grid,int k,Queue<state> q,boolean[][][] vis,int n,int m){
16        int steps=0;
17        while(!q.isEmpty()){
18            int size=q.size();
19            for(int i=0;i<size;i++){
20                state cur=q.poll();
21                int r=cur.r;
22                int c=cur.c;
23                int rk=cur.rk;
24                if(r==n-1&&c==m-1){
25                    return steps;
26                }
27                for(int j=0;j<4;j++){
28                    int nx=r+dx[j];
29                    int ny=dy[j]+c;
30                    if(nx<0||nx>=n||ny<0||ny>=m){
31                        continue;
32                    }
33                    int newk=rk;
34                    if(grid[nx][ny]==1){
35                        if(rk==0){
36                            continue;
37                        }
38                        newk=rk-1;
39                    }
40                    if(!vis[nx][ny][newk]){
41                        vis[nx][ny][newk]=true;
42                        q.add(new state(nx,ny,newk));
43                                
44                    }
45                        
46                   
47                }
48
49            }
50            steps++;
51        }
52        return -1;
53    }
54    public int shortestPath(int[][] grid, int k) {
55        int n=grid.length;
56        int m=grid[0].length;
57        Queue<state> q=new LinkedList<>();
58        boolean[][][] vis=new boolean[n][m][k+1];
59        q.add(new state(0,0,k));
60        vis[0][0][k]=true;
61        return solve(grid,k,q,vis,n,m);
62        
63    }
64}