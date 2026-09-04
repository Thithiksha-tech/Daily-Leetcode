1class Solution {
2    public int numDecodings(String s) {
3        int n=s.length();
4        if(s.charAt(0)=='0'){
5            return 0;
6        }
7        
8        int[] dp=new int[s.length()+1];
9        dp[n]=1;
10        for(int i=n-1;i>=0;i--){
11            //one digit
12            if(s.charAt(i)=='0'){
13                continue;
14            }
15            dp[i]=dp[i+1];
16            //two digits
17            if(i+1<n){
18                int two=(s.charAt(i)-'0')*10+
19                (s.charAt(i+1)-'0');
20                if(two>=10&&two<=26){
21
22                    dp[i]+=dp[i+2];
23                }
24            }
25        }
26
27        return dp[0];
28    }
29}   