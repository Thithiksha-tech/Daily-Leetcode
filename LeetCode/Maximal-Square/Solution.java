1class Solution {
2    public int maximalSquare(char[][] grid) {
3        int n=grid.length;
4        int m=grid[0].length;
5        int[][] g=new int[n][m];
6        for(int i=0;i<n;i++){
7            for(int j=0;j<m;j++){
8                g[i][j]=grid[i][j]-'0';
9            }
10        }
11        int max=0;
12        int[][] dp=new int[n][m];
13        for(int i=0;i<m;i++){
14            dp[0][i]=g[0][i];
15            max=Math.max(max,dp[0][i]);
16        }
17        for(int j=0;j<n;j++){
18            dp[j][0]=g[j][0];
19            max=Math.max(max,dp[j][0]);
20        }
21        for(int i=1;i<n;i++){
22            for(int j=1;j<m;j++){
23                if(g[i][j]==1){
24                    //min of left,top,top,left;
25                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
26                }
27                max=Math.max(max,dp[i][j]);
28
29            }
30        }
31        return max*max;
32    }
33}