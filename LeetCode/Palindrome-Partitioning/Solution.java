1class Solution {
2    static List<List<String>> ans=new ArrayList<>();
3    public static boolean ispali(String s){
4        int l=0;
5        int h=s.length()-1;
6        while(l<h){
7            if(s.charAt(l)!=s.charAt(h)){
8                return false;
9            }
10            l++;
11            h--;
12        }
13        return true;
14    }
15    public static void solve(int ind,String s,ArrayList<String> val){
16        if(ind==s.length()){
17            ans.add(new ArrayList<>(val));
18            return;
19        }
20        for(int i=ind;i<s.length();i++){
21            if(ispali(s.substring(ind,i+1))){
22                String u=s.substring(ind,i+1);
23                val.add(u);
24                solve(i+1,s,val);
25                val.remove(val.size()-1);
26
27            }
28        }
29        
30    }
31
32    public List<List<String>> partition(String s) {
33        ans.clear();
34        
35        solve(0,s,new ArrayList<>());
36        return ans;
37        
38    }
39}