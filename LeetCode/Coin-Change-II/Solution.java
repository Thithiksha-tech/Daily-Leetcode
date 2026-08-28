1class Solution {
2    public int change(int amount, int[] coins) {
3        int n=coins.length;
4        int[] dp=new int[amount+1];
5        dp[0]=1;
6        for(int coin:coins){
7            //with one coin what and all amounts we can make
8            for(int i=coin;i<=amount;i++){
9                dp[i]+=dp[i-coin];
10            }
11
12
13        }
14        return dp[amount];
15        
16        
17    }
18}