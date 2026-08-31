class Solution {
    static int count=0;
    public static void solve(int[] nums,int target,int ind,int sum){
        if(ind==nums.length){
            if(sum==target){
                count++;
            }
            return;
        }
        solve(nums,target,ind+1,sum+nums[ind]);
        solve(nums,target,ind+1,sum-nums[ind]);

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
        solve(nums,target,0,0);
    
        return count;
        
    }
}