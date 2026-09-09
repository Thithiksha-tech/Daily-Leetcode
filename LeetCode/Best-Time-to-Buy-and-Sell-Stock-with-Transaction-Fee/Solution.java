1class Solution {
2    public int maxProfit(int[] p, int fee) {
3        int n=p.length;
4        int[][] dp=new int[n][2];
5        dp[0][0]=-p[0];
6        dp[0][1]=0;
7        int max=0;
8        for(int i=1;i<n;i++){
9            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-p[i]);
10            dp[i][1]=Math.max(dp[i-1][0]+p[i]-fee,dp[i-1][1]);
11         
12        }
13        return dp[n-1][1];
14    }
15}