class Solution {
    public int maxProfit(int[] p){
        int n=p.length;
        
        int[][] dp=new int[n][4];
        dp[0][0]=-p[0];
        dp[0][1]=0;
        dp[0][2]=-p[0];
        dp[0][3]=0;
        for(int i=1;i<n;i++){
            //FIRST BUY
            dp[i][0]=Math.max(dp[i-1][0],-p[i]);

            //FIRST SELL
            dp[i][1]=Math.max(dp[i-1][0]+p[i],dp[i-1][1]);

            //SECOND BUY
            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]-p[i]);

            //SECOND SELL
            dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2]+p[i]);
        }
        return Math.max(dp[n-1][1],dp[n-1][3]);

    }
}