1class Solution {
2    public static int solve(int n,int st,int ed,int[] nums){
3        int[] dp=new int[n];
4        dp[st]=nums[st];
5        dp[st+1]=Math.max(nums[st+1],dp[st]);
6        for(int i=st+2;i<=ed;i++){
7            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
8        }
9        return dp[ed];
10    }
11    public int rob(int[] nums) {
12        int n=nums.length;
13        if(n==1){
14            return nums[0];
15        }
16        if(n==2){
17            return Math.max(nums[1],nums[0]);
18        }
19        
20        int rob1=solve(n,0,n-2,nums);
21        int rob2=solve(n,1,n-1,nums);
22        return Math.max(rob1,rob2);
23         
24        
25    }
26}