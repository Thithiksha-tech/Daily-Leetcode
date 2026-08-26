1class Solution {
2    public int minPathSum(int[][] grid) {
3        int n=grid.length;
4        int m=grid[0].length;
5        int[][] dp=new int[n][m];
6        for(int i = 0; i < dp.length; i++) {
7            Arrays.fill(dp[i], Integer.MAX_VALUE);
8        }
9
10        dp[0][0]=grid[0][0];
11        
12        for(int i=1;i<n;i++){
13            dp[i][0]=dp[i-1][0]+grid[i][0];
14        }
15        for(int i=1;i<m;i++){
16            dp[0][i]=dp[0][i-1]+grid[0][i];
17        }
18        for(int i=1;i<n;i++){
19            for(int j=1;j<m;j++){
20                dp[i][j]=Math.min(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
21            }
22        }
23        return dp[n-1][m-1];
24    }
25}