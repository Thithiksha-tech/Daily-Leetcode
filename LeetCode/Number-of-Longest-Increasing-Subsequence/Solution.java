1class Solution {
2    public int findNumberOfLIS(int[] nums) {
3        
4        int n=nums.length;
5        int[] count=new int[n];
6        int[] dp=new int[n];
7        for(int i=0;i<n;i++){
8            dp[i]=1;
9            count[i]=1;
10        }
11        int maxlength=1;
12        int ans=0;
13        for(int i=0;i<n;i++){
14            for(int j=0;j<i;j++){
15                if(nums[j]<nums[i]){
16                    if(dp[j]+1>dp[i]){
17                        dp[i]=dp[j]+1;
18                        count[i]=count[j];
19                    }
20                    else if(dp[j]+1==dp[i]){
21                        count[i]+=count[j];
22
23                    }
24                }
25
26                
27            }
28            maxlength=Math.max(maxlength,dp[i]);
29        }
30        for(int i=0;i<n;i++){
31            if(dp[i]==maxlength){
32                ans+=count[i];
33            }
34        }
35        return ans;
36    }
37}