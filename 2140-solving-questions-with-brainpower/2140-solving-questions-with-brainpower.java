class Solution {
    public long mostPoints(int[][] nums) {
        int n=nums.length;
        long[] dp=new long[n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            long points=nums[i][0];
            //from that position skip that numbers the current number
            int next=i+nums[i][1]+1;
            long take=0;

            if(next>=n){
                take=points;
            }
            else{
                take=points+dp[next];
            }
            long skip=dp[i+1];
            dp[i]=Math.max(skip,take);

        }
        return dp[0];

        
        
    }
}