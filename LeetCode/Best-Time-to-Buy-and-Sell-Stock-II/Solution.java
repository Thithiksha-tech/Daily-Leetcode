1class Solution {
2    public int maxProfit(int[] p) {
3        int n=p.length;
4        int[][] dp=new int[n][2];
5        dp[0][0]=-p[0];
6        dp[0][1]=0;
7        //0->buy
8        //1->sell
9        for(int i=1;i<n;i++){
10            //today buy
11            //yesterday didnt buy VS yest sell today buy
12            /* if i had to buy today yesterday i should have selled it */
13            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-p[i]);
14
15            //today sell
16            /*if i had to sell today yesterday i should have buyed it */
17            //yesteday didt buy  VS yesterday sell today buy
18            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+p[i]);
19        }
20        return dp[n-1][1];
21        
22    }
23}