class Solution {
    public boolean canFinish(int n, int[][] pre) {
   
        int[] indeg=new int[n];
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] g=new ArrayList[n];
        for(int i=0;i<n;i++){
            g[i]=new ArrayList<>();
        }
        for(int i=0;i<pre.length;i++){
            int u=pre[i][1];
            int v=pre[i][0];
            g[u].add(v);
            indeg[v]++;
        }
        ArrayList<Integer> topo=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.poll();
            topo.add(node);
            for(int nei:g[node]){
                int v=nei;
                indeg[v]--;
                if(indeg[v]==0){
                    q.add(v);
                }
            }
        }
        if(topo.size()==n){
            return true;
        }
        return false;
        
    }
}