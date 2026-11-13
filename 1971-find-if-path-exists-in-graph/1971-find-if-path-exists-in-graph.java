class Solution {
    public static boolean bfs(int s,int d,int parent,Queue<Integer> q,ArrayList<Integer>[] g,int n,boolean[] vis){
        q.add(s);
        vis[s]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            if(node==d){
                return true;

            }
            for(int nei:g[node]){
                if(!vis[nei]){
                    vis[nei]=true;
                    q.add(nei);
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
        return bfs(s,d,-1,q,g,n,vis);

        
    }
}