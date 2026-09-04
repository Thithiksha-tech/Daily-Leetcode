1class Solution {
2    public int minDistance(String w1, String w2) {
3        int n=w1.length();
4        int m=w2.length();
5        if(w1.equals("")&&w2.equals("")){
6            return 0;
7        }
8        if(w1.equals("")||w2.equals("")){
9            return Math.max(w1.length(),w2.length());
10        }
11        int[][] dp=new int[n+1][m+1];
12   
13        for(int i=0;i<=m;i++){
14            dp[0][i]=i;
15        }
16        for(int i=0;i<=n;i++){
17            dp[i][0]=i;
18        }
19        for(int i=1;i<=n;i++){
20            for(int j=1;j<=m;j++){
21                if(w1.charAt(i-1)!=w2.charAt(j-1)){
22                    dp[i][j]=Math.min(dp[i-1][j],Math.min(
23                    dp[i][j-1],dp[i-1][j-1]))+1;
24                }
25                else{
26                    dp[i][j]=dp[i-1][j-1];
27                }
28            }
29        }
30        return dp[n][m];
31    }
32}