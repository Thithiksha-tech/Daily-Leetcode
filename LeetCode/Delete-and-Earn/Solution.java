1class Solution {
2    public int deleteAndEarn(int[] nums) {
3        int max=0;
4        int n=nums.length;
5        for(int i=0;i<n;i++){
6            max=Math.max(max,nums[i]);
7        }
8        //arranging them order
9        int[] points=new int[max+1];
10        for(int i=0;i<n;i++){
11            points[nums[i]]+=nums[i];
12        }
13        int[] dp=new int[max+1];
14        dp[0]=points[0];
15        dp[1]=points[1];
16        for(int i=2;i<=max;i++){
17            dp[i]=Math.max(dp[i-1],dp[i-2]+points[i]);
18        }
19        return dp[max];
20
21    }
22}