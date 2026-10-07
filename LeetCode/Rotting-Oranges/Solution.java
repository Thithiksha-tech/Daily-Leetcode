1class Solution {
2    static int[] dx={-1,1,0,0};
3    static int[] dy={0,0,-1,1};
4    public static int solve(Queue<int[]> q,int[][] grid,int n,int m,int fresh){
5        int min=0;
6        while(!q.isEmpty()&&fresh>0){
7            int size=q.size();
8            for(int k=0;k<size;k++){
9                int[] curr=q.poll();
10                int x=curr[0];
11                int y=curr[1];
12                
13                for(int i=0;i<4;i++){
14                    int nx=x+dx[i];
15                    int ny=y+dy[i];
16                    if(nx>=0&&nx<n&&ny>=0&&ny<m){
17                        if(grid[nx][ny]==1){
18                            grid[nx][ny]=2;
19                            fresh--;
20                            q.add(new int[]{nx,ny});
21                        }
22                    }
23
24                }
25
26            }
27            min++;
28        }
29        return fresh==0?min:-1;
30
31    }
32    public int orangesRotting(int[][] grid) {
33        int n=grid.length;
34        int m=grid[0].length;
35    
36        int fresh=0;
37        Queue<int[]> q=new LinkedList<>();
38        for(int i=0;i<n;i++){
39            for(int j=0;j<m;j++){
40                if(grid[i][j]==2){
41                    q.add(new int[]{i,j});
42                }
43                if(grid[i][j]==1){
44                    fresh++;
45                }
46            }
47        }
48     
49        
50   
51        return solve(q,grid,n,m,fresh);
52
53        
54    }
55}