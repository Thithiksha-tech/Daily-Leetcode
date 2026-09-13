1class Solution {
2    public int minCostClimbingStairs(int[] cost) {
3        int n=cost.length;
4        int[] dp=new int[cost.length+1];
5        dp[0]=0;
6        dp[1]=0;
7        //strat from 0step or 1 step
8        for(int i=2;i<=n;i++){
9            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
10        }
11        return dp[n];
12        
13    }
14}