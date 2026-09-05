1class Solution {
2    public int longestCommonSubsequence(String t1, String t2) {
3        int[][] dp=new int[t1.length()+1][t2.length()+1];
4        for(int i=1;i<=t1.length();i++){
5            for(int j=1;j<=t2.length();j++){
6                if(t1.charAt(i-1)!=t2.charAt(j-1)){
7                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
8                }
9                else{
10                    dp[i][j]=dp[i-1][j-1]+1;
11                }
12            }
13        }
14        return dp[t1.length()][t2.length()];
15        
16    }
17}