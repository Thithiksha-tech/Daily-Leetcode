class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        int[] dp=new int[pairs.length];
        int n=pairs.length;
        for(int i=0;i<n;i++){
            dp[i]=1;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(pairs[j][1]<pairs[i][0]){
                    dp[i]=dp[j]+1;
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}