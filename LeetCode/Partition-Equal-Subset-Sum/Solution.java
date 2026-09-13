1class Solution {
2    
3    public boolean canPartition(int[] nums) {
4        int n=nums.length;
5        int tot=0;
6        for(int x:nums){
7            tot+=x;
8        }
9        if(tot%2!=0){
10            return false;
11        }
12        int target=tot/2;
13        boolean[][] dp=new boolean[n+1][target+1];
14        //So when idx == n:
15
16        //target 0 → true
17        //everything else → false
18        //dp[index][target]
19        dp[n][0]=true;
20        for(int idx=n-1;idx>=0;idx--){
21            for(int sum=0;sum<=target;sum++){
22                boolean np=dp[idx+1][sum];
23                boolean pick=false;
24                if(nums[idx]<=sum){
25                    pick=dp[idx+1][sum-nums[idx]];
26
27                }
28                dp[idx][sum]=pick||np;
29            }
30        }
31        return dp[0][target];
32        
33        
34    }
35}