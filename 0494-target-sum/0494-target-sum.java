class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int tot=0;
        for(int x:nums){
            tot+=x;
        } 
         if (Math.abs(target) > tot) {
            return 0;
        }
 
        int[][] dp=new int[n+1][2*tot+1];
        dp[0][0+tot]=1;
        for(int i=0;i<n;i++){
            for(int sum=-tot;sum<=tot;sum++){
                int ways=dp[i][sum+tot];
                if(ways==0){
                    continue;
                }
                dp[i+1][sum+nums[i]+tot]+=dp[i][sum+tot];
                dp[i+1][sum-nums[i]+tot]+=dp[i][sum+tot];
            }
        }
        return dp[n][tot+target];
    }
}










