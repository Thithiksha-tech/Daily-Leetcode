1class Solution {
2    public int uniquePaths(int m, int n) {
3        int[][] dp=new int[m][n];
4        dp[0][0]=0;
5        for(int i=0;i<m;i++){
6            dp[i][0]=1;
7        }
8        for(int i=0;i<n;i++){
9            dp[0][i]=1;
10        }
11        for(int i=1;i<m;i++){
12            for(int j=1;j<n;j++){
13                dp[i][j]=dp[i-1][j]+dp[i][j-1];
14            }
15        }
16        return dp[m-1][n-1];
17    }
18}