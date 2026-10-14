1class Solution {
2    
3    public static void solve(int op,int cl,int n,StringBuilder res,ArrayList<String> ans){
4        if(op==n&&cl==n){
5            ans.add(res.toString());
6            return;
7        }
8        if(op<n){
9            res.append("(");
10            solve(op+1,cl,n,res,ans);
11            res.deleteCharAt(res.length()-1);
12        }
13        if(cl<op){
14            res.append(")");
15            solve(op,cl+1,n,res,ans);
16            res.deleteCharAt(res.length()-1);
17        }
18    }
19    public List<String> generateParenthesis(int n) {
20        StringBuilder res=new StringBuilder();
21        ArrayList<String> ans=new ArrayList<>();
22        solve(0,0,n,res,ans);
23        return ans;
24        
25    }
26}