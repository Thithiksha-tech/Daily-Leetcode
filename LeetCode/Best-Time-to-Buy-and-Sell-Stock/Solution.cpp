1class Solution {
2    public int maxProfit(int[] prices) {
3        int l=0;
4        int h=1;
5        if(prices.length==1){
6            return 0;
7        }
8        int max=Integer.MIN_VALUE;
9        while(h<prices.length){
10            if(prices[h]<prices[l]){
11                l=h;
12              
13
14            }
15            else{
16                max=Math.max(max,prices[h]-prices[l]);
17                h++;
18            }
19            
20             
21        }
22        return max;
23        
24    }
25}