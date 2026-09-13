1class Solution {
2    public int uniquePathsWithObstacles(int[][] grid) {
3        int n=grid.length;
4        int m=grid[0].length;
5        int[][] dp=new int[n+1][m+1];
6        if(grid[0][0]==1){
7            return 0;
8        }
9        dp[0][0]=0;
10        for(int i=0;i<n;i++){
11            if(grid[i][0]!=1){
12                dp[i][0]=1;
13            }
14            else{
15                break;
16            }
17        }
18        for(int i=0;i<m;i++){
19            if(grid[0][i]!=1){
20                dp[0][i]=1;
21            }
22            else{
23                break;
24            }
25        }
26        for(int i=1;i<n;i++){
27            for(int j=1;j<m;j++){
28                if(grid[i][j]!=1){
29                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
30                }
31                else{
32                    dp[i][j]=0;
33                }
34            }
35        }
36        return dp[n-1][m-1];
37        
38    }
39}