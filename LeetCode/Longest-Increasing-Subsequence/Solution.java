1class Solution {
2    public int lengthOfLIS(int[] nums) {
3        int[] dp=new int[nums.length];
4        int n=nums.length;
5        for(int i=0;i<n;i++){
6            dp[i]=1;
7        }
8        int ans=0;
9        for(int i=0;i<n;i++){
10            for(int j=0;j<i;j++){
11                if(nums[j]<nums[i]){//smaller privious
12                    dp[i]=Math.max(dp[i],dp[j]+1);
13                }
14            }
15            ans=Math.max(ans,dp[i]);
16            
17        }
18        return ans;
19
20        
21    }
22}