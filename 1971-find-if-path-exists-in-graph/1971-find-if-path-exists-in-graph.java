class Solution {
    public static boolean dfs(int s,int d,ArrayList<Integer>[] g,int n,boolean[] vis){
        vis[s]=true;
        if(s==d){
            return true;
        }
        for(int nei:g[s]){
            if(!vis[nei]){ 
                if(dfs(nei,d,g,n,vis)){
                    return true;
                }

            }
        }
        return false;
        
        
    }
    public boolean validPath(int n, int[][] e, int s, int d) {
        Queue<Integer> q=new LinkedList<>();
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] g=new ArrayList[n+1];
        for(int i=0;i<n;i++){
            g[i]=new ArrayList<>();

        }
     
        for (int[] edge : e) {
            int u = edge[0];
            int v = edge[1];
            g[u].add(v);
            g[v].add(u); // Undirected graph goes both ways
        }
     
        boolean[] vis=new boolean[n];
        return dfs(s,d,g,n,vis);

        
    }
}