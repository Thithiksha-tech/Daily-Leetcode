1class Solution {
2    static List<List<Integer>> ans=new ArrayList<>();
3    public static void solve(int[][] graph,int target,ArrayList<Integer> val,int ind){
4    
5        if(ind==target){
6           
7            ans.add(new ArrayList<>(val));
8            return;
9        }
10        
11        for(int i=0;i<graph[ind].length;i++){
12     
13            val.add(graph[ind][i]);
14            solve(graph,target,val,graph[ind][i]);
15            val.remove(val.size()-1);
16        }
17    }
18
19    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
20        ans.clear();
21        int target=graph.length-1;
22        ArrayList<Integer> val=new ArrayList<>();
23        val.add(0);
24        solve(graph,target,val,0);
25        return ans;
26        
27    }
28}