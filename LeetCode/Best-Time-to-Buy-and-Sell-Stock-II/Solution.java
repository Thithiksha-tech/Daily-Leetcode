1class Solution {
2    public int maxProfit(int[] p) {
3        int profit=0;
4        for(int i=1;i<p.length;i++){
5            if(p[i]>p[i-1]){
6                profit+=(p[i]-p[i-1]);
7            }
8        }
9        return profit;
10        
11    }
12}