1class Solution {
2    public int climbStairs(int n) {
3        if(n<=2){
4            return n;
5
6        }
7        int[] dp=new int[n+1];
8        dp[0]=0;
9        dp[1]=1;
10        dp[2]=2;
11        for(int i=3;i<=n;i++){
12            dp[i]=dp[i-1]+dp[i-2];
13        }
14        return dp[n];
15        
16    }
17}