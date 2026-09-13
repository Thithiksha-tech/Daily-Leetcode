1class Solution {
2    public long mostPoints(int[][] nums) {
3        int n=nums.length;
4        long[] dp=new long[n+1];
5        dp[n]=0;
6        for(int i=n-1;i>=0;i--){
7            long points=nums[i][0];
8            //from that position skip that numbers the current number
9            int next=i+nums[i][1]+1;
10            long take=0;
11
12            if(next>=n){
13                take=points;
14            }
15            else{
16                take=points+dp[next];
17            }
18            long skip=dp[i+1];
19            dp[i]=Math.max(skip,take);
20
21        }
22        return dp[0];
23
24        
25        
26    }
27}