1class Solution {
2    public int minimumTotal(List<List<Integer>> list) {
3        int n=list.size();
4        int[][] dp=new int[n][n];
5        for(int j=0;j<n;j++){
6            dp[n-1][j]=list.get(n-1).get(j);
7        }
8        for(int i=n-2;i>=0;i--){
9            for(int j=0;j<=i;j++){
10                dp[i][j]=list.get(i).get(j)+Math.min(
11                dp[i+1][j],dp[i+1][j+1]);
12            }
13        }
14        
15    return dp[0][0];
16    }
17}