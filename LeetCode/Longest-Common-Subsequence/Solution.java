1class Solution {
2    public int longestCommonSubsequence(String s1, String s2) {
3        int[][] dp=new int[s1.length()+1][s2.length()+1];
4        for(int i=1;i<=s1.length();i++){
5        char ch1=s1.charAt(i-1);
6            for(int j=1;j<=s2.length();j++){
7                char ch2=s2.charAt(j-1);
8                if(ch1==ch2){
9                    dp[i][j]=1+dp[i-1][j-1];
10                }
11                else{
12                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
13                }
14            }
15        }
16        return dp[s1.length()][s2.length()];
17        
18    }
19}