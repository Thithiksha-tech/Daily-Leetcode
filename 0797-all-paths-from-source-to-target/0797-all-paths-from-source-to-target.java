class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] g) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<List<Integer>> q=new LinkedList<>();
        List<Integer> st=new ArrayList();
        st.add(0);
        q.add(st);
        while(!q.isEmpty()){
            List<Integer> path=q.poll();
            int node=path.get(path.size()-1);
            if(node==g.length-1){
                res.add(path);
                continue;
            }
            for(int nei:g[node]){
                List<Integer> newpath=new ArrayList<>(path);
                newpath.add(nei);
                q.add(newpath);
            }
        }
        return res;
    }
}