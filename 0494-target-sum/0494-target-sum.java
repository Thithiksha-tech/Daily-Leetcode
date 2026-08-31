class Solution {
    static int count=0;
    static int[][] dp;
    public static int solve(int[] nums,int target,int ind,int sum,int tot){
        if(ind==nums.length){
            if(sum==target){
                return 1;
            }
            return 0;
            
        }
        int index=sum+tot;
        if(dp[ind][index]!=-1){
            return dp[ind][index];
        }
        int plusways=solve(nums,target,ind+1,sum+nums[ind],tot);
        int minusways=solve(nums,target,ind+1,sum-nums[ind],tot);
        dp[ind][index]=plusways+minusways;
        return dp[ind][index];

    }
    public int findTargetSumWays(int[] nums, int target) {
        count=0;
        // if(nums.length==1){
        //     if(nums[0]==target||nums[0]==-target){
        //         return 1;
        //     }
        //     else{
        //         return 0;
        //     }
        // }
        int tot=0;
        for(int i=0;i<nums.length;i++){
            tot+=nums[i];
        }
        int n=nums.length;
        dp=new int[n+1][2*tot+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=solve(nums,target,0,0,tot);
    
        return ans;
        
    }
}