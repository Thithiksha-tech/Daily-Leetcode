1class Solution {
2    public int maxProfit(int[] p) {
3        int n=p.length;
4        int[][] dp=new int[n][3];
5        
6        dp[0][0]=-p[0];
7        dp[0][1]=0;
8        dp[0][2]=0;
9        for(int i=1;i<n;i++){
10            //BUY STATE
11            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][2]-p[i]);
12            //SELL STATE
13            dp[i][1]=dp[i-1][0]+p[i];
14            //REST STATE
15            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]);
16        }
17        return Math.max(dp[n-1][1],dp[n-1][2]);
18        
19    }
20}