1class Solution {
2    public List<List<Integer>> allPathsSourceTarget(int[][] g) {
3        Queue<List<Integer>> q=new LinkedList<>();
4        List<List<Integer>> ans=new LinkedList<>();
5        List<List<Integer>> result=new ArrayList<>();
6        List<Integer> st=new ArrayList<>();
7        st.add(0);
8        q.add(st);
9        while(!q.isEmpty()){
10            
11            List<Integer> path=q.poll();
12            int node=path.get(path.size()-1);
13            if(node==g.length-1){
14                result.add(path);
15                continue;
16            }
17            for(int nei:g[node]){
18                List<Integer> newpath=new ArrayList<>(path);
19                newpath.add(nei);
20                q.add(newpath);
21            }
22
23        }
24        return result;
25        
26    }
27}