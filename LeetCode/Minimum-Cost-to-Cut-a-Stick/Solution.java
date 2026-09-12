1class Solution {
2    public int minCost(int n, int[] cuts) {
3        int m=cuts.length;
4        int[] arr=new int[m+2];
5        arr[0]=0;
6        arr[m+1]=n;
7        for(int i=0;i<m;i++){
8            arr[i+1]=cuts[i];
9        }
10        Arrays.sort(arr);
11        int[][] dp=new int[m+2][m+2];
12        //min cuts
13        for(int len=2;len<m+2;len++){
14            for(int i=0; i+len<m+2 ;i++){
15                int j=i+len;
16                dp[i][j]=Integer.MAX_VALUE;
17                for(int k=i+1;k<j;k++){
18                    //best options +remaining
19                    int cost=dp[i][k]+dp[k][j]+(arr[j]-arr[i]);
20                    dp[i][j]=Math.min(dp[i][j],cost);
21                }
22
23            }
24        }
25        return dp[0][m+1];
26        
27    }
28}