1class Solution {
2    static List<String> ans=new ArrayList<>();
3    public static void solve(String s,int ind,int parts,String path){
4        if(parts==4){
5            if(ind==s.length()){
6                ans.add(path.substring(0,path.length()-1));
7            }
8            return;
9        }
10        //base
11        String curr="";
12        for(int end=ind;end<s.length()&&end<ind+3;end++){
13            curr+=s.charAt(end);
14            if(curr.length()>1&&curr.charAt(0)=='0'){
15                break;
16            }
17            if(Integer.parseInt(curr)>255){
18                break;
19
20            }
21            
22            String newPath=path+curr+".";
23            solve(s,end+1,parts+1,newPath);
24
25        }
26    }
27    public List<String> restoreIpAddresses(String s) {
28        ans.clear();
29        solve(s,0,0,"");
30        return ans;
31        
32    }
33}