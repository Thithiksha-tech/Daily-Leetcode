class Solution {
    
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int tot=0;
        for(int x:nums){
            tot+=x;
        }
        if(tot%2!=0){
            return false;
        }
        int target=tot/2;
        boolean[][] dp=new boolean[n+1][target+1];
        //So when idx == n:

        //target 0 → true
        //everything else → false
        //dp[index][target]
        dp[n][0]=true;
        for(int idx=n-1;idx>=0;idx--){
            for(int sum=0;sum<=target;sum++){
                boolean np=dp[idx+1][sum];
                boolean pick=false;
                if(nums[idx]<=sum){
                    pick=dp[idx+1][sum-nums[idx]];

                }
                dp[idx][sum]=pick||np;
            }
        }
        return dp[0][target];
        
        
    }
}