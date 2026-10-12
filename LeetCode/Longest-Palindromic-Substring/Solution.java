1class Solution {
2    public static int expand(String s,int left,int right){
3        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
4            left--;
5            right++;
6        }
7        return right-left-1;
8    }
9    public String longestPalindrome(String s) {
10        int start=0;
11        int end=0;
12        for(int i=0;i<s.length();i++){
13            int len1=expand(s,i,i); /*even index*/
14            int len2=expand(s,i,i+1); /*odd index*/
15            int len=Math.max(len1,len2);
16            if(len>end-start+1){
17                start=i-(len-1)/2;
18                end=i+len/2;
19
20            }
21            
22        }
23        return s.substring(start,end+1);
24        
25    }
26}