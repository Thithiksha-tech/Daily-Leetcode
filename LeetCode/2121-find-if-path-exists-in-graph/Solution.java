class Solution {
    public boolean validPath(int n, int[][] edges, int s, int d) {
        ArrayList<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        Queue<Integer> q=new LinkedList<>();
        boolean[] vis=new boolean[n];
        q.add(s);
        vis[s]=true;
        while(!q.isEmpty()){
            int cur=q.poll();
            if(cur==d){
                return true;
            }
            for(int v:graph[cur]){
                if(!vis[v]){
                    q.add(v);
                    vis[v]=true;
                }
            }
        }
        return false;
        
    }
}