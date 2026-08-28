1class Solution {
2    public int minFallingPathSum(int[][] matrix) {
3        int n=matrix.length;
4        int m=matrix[0].length;
5        int[][] dp=new int[n][m];
6        // for(int[] row:dp){
7        //     Arrays.fill(row,Integer.MAX_VALUE);
8        // }
9        for(int i=0;i<m;i++){
10            dp[0][i]=matrix[0][i];
11        }
12        
13        for(int i=1;i<n;i++){
14            for(int j=0;j<m;j++){
15                if(j==0){
16                    dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j+1]);
17                }
18                else if(j==m-1){
19                    dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j-1],dp[i-1][j]);
20                }
21                else{
22                    dp[i][j] = matrix[i][j]
23                            + Math.min(
24                                dp[i - 1][j - 1],
25                                Math.min(
26                                    dp[i - 1][j],
27                                    dp[i - 1][j + 1]
28                                )
29                            );
30                }
31            }
32        }
33        int ans=dp[n-1][0];
34        for(int j=1;j<m;j++){
35            ans=Math.min(ans,dp[n-1][j]);
36        }
37        return ans;
38        
39        
40    }
41}