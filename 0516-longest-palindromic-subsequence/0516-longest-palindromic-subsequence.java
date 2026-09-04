class Solution {
    public static int lcs(String s,String res){
        int n=s.length();
        int[][] dp=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)!=res.charAt(j-1)){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
                else{
                    dp[i][j]=dp[i-1][j-1]+1;
                }
            }
        }
        return dp[n][n];
    }
    public static String rev(String s){
        String res="";
        for(int i=s.length()-1;i>=0;i--){
            res+=s.charAt(i);
        }
        return res;
    }
    public int longestPalindromeSubseq(String s) {
        return lcs(s,rev(s));
        
    }
}