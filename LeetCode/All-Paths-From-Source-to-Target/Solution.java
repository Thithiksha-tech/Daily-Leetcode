1class Solution {
2    public List<List<Integer>> allPathsSourceTarget(int[][] g) {
3        List<List<Integer>> res=new ArrayList<>();
4        Queue<List<Integer>> q=new LinkedList<>();
5        List<Integer> st=new ArrayList();
6        st.add(0);
7        q.add(st);
8        while(!q.isEmpty()){
9            List<Integer> path=q.poll();
10            int node=path.get(path.size()-1);
11            if(node==g.length-1){
12                res.add(path);
13                continue;
14            }
15            for(int nei:g[node]){
16                List<Integer> newpath=new ArrayList<>(path);
17                newpath.add(nei);
18                q.add(newpath);
19            }
20        }
21        return res;
22    }
23}