1class Solution {
2    public int rob(int[] nums) {
3        if(nums.length==1){
4            return nums[0];
5        }
6        int[] dp=new int[nums.length];
7        dp[0]=nums[0];
8        int n=nums.length;
9        dp[1]=Math.max(dp[0],nums[1]);
10        if(nums.length==2){
11            return dp[nums.length-1];
12        }
13        for(int i=2;i<nums.length;i++){
14            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
15        }
16        return dp[n-1];
17        
18    }
19}