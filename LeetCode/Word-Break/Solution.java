1class Solution {
2    public boolean wordBreak(String s, List<String> wordDict) {
3        boolean[] dp=new boolean[s.length()+1];
4        dp[0]=true;
5        
6        for(int i=0;i<=s.length();i++){
7            if(!dp[i]){
8                continue;
9            }
10            for(String w:wordDict){
11                if(i+w.length()<=s.length()){
12                    boolean match=true;
13                    for(int j=0;j<w.length();j++){
14                        if(s.charAt(i+j)!=w.charAt(j)){
15                            match=false;
16                            break;
17                        }
18                    }
19                    if(match){
20                        dp[i+w.length()]=true;
21                    }
22                }
23            }
24        }
25        return dp[s.length()];
26        
27    }
28}