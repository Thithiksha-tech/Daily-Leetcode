1class Solution {
2    static List<String> ans=new ArrayList<>();
3    public static void solve(int n,int ind,int open,int close,StringBuilder res){
4        if(res.length()==2*n){
5            ans.add(res.toString());
6            return;
7        }
8        if(open<n){
9            res.append("(");
10            solve(n,ind+1,open+1,close,res);
11            res.deleteCharAt(res.length()-1);
12        }
13        if(close<open){
14            res.append(")");
15            solve(n,ind+1,open,close+1,res);
16            res.deleteCharAt(res.length()-1);
17        }
18    }
19    public List<String> generateParenthesis(int n) {
20        ans.clear();
21        StringBuilder s=new StringBuilder();
22        solve(n,0,0,0,s);
23        return ans;
24    }
25}