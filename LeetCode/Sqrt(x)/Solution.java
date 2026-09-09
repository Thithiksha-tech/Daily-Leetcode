1class Solution {
2    public int mySqrt(int x) {
3        int l=0;
4        int r=x;
5        int ans=0;
6        while(l<=r){
7            long mid=l+(r-l)/2;
8            long sq=(long)mid*mid;
9            if(sq==x){
10                return (int)mid;
11            }
12            else if(sq>x){
13                r=(int)mid-1;
14            }
15            else{
16                ans=(int)mid;
17                l=(int)mid+1;
18            }
19        }
20        return ans;
21        
22    }
23}