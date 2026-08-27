class Solution {
    public static int solve(int n,int st,int ed,int[] nums){
        int[] dp=new int[n];
        dp[st]=nums[st];
        dp[st+1]=Math.max(nums[st+1],dp[st]);
        for(int i=st+2;i<=ed;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[ed];
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[1],nums[0]);
        }
        
        int rob1=solve(n,0,n-2,nums);
        int rob2=solve(n,1,n-1,nums);
        return Math.max(rob1,rob2);
         
        
    }
}