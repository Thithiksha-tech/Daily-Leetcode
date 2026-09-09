1class Solution {
2    public int maxProfit(int k, int[] p) {
3        int n=p.length;
4        int[][] dp=new int[n][2*k];
5        for(int j=0;j<2*k;j++){
6            if(j%2==0){
7                dp[0][j]=-p[0];
8            }
9            
10            else{
11                    dp[0][j]=0;
12            }
13            
14        }
15        for(int i=1;i<n;i++){
16            for(int j=0;j<2*k;j++){
17                if(j%2==0){
18                    if(j==0){
19                        dp[i][j]=Math.max(dp[i-1][j],-p[i]);
20                    }
21                    else{
22                        dp[i][j]=Math.max(dp[i-1][j-1]-p[i],dp[i-1][j]);
23                    }
24                }
25                else{
26                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1]+p[i]);
27                }
28            }
29        }
30        
31        return dp[n-1][2*k-1];
32        
33    }
34}