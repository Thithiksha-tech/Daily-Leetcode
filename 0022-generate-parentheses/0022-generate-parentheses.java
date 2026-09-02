class Solution {
    static List<String> ans=new ArrayList<>();
    public static void solve(int n,int ind,int open,int close,StringBuilder res){
        if(res.length()==2*n){
            ans.add(res.toString());
            return;
        }
        if(open<n){
            res.append("(");
            solve(n,ind+1,open+1,close,res);
            res.deleteCharAt(res.length()-1);
        }
        if(close<open){
            res.append(")");
            solve(n,ind+1,open,close+1,res);
            res.deleteCharAt(res.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        ans.clear();
        StringBuilder s=new StringBuilder();
        solve(n,0,0,0,s);
        return ans;
    }
}