class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int coin:coins){
            //with one coin what and all amounts we can make
            for(int i=coin;i<=amount;i++){
                dp[i]+=dp[i-coin];
            }


        }
        return dp[amount];
        
        
    }
}