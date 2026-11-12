class Solution {
    public static void dfs(int node,ArrayList<Integer>[] a,boolean[] vis,int n,ArrayList<Integer> path,List<List<Integer>> ans){
        if(node==n-1){
            path.add(node);
           
            ans.add(new ArrayList<>(path));
            path.remove(path.size()-1);
        }
        path.add(node);
        vis[node]=true;
        
        for(int nei:a[node]){
            if(!vis[nei]){
                dfs(nei,a,vis,n,path,ans);
            }
            
        }
        path.remove(path.size()-1);
        vis[node]=false;

    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans=new ArrayList<>();
        int n=graph.length;
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] a=new ArrayList[n+1];
        for(int i=0;i<n;i++){
            a[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            for(int x:graph[i]){
                a[i].add(x);
            }
        }
        boolean[] vis=new boolean[graph.length];
        dfs(0,a,vis,n,new ArrayList<>(),ans);
        return ans;

        
    }
}