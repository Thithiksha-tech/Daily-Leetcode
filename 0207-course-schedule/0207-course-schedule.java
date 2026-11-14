class Solution {
    public boolean canFinish(int n, int[][] pre) {
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] g=new ArrayList[n+1];
        for(int i=0;i<n;i++){
            g[i]=new ArrayList<>();

        }
        int[] indeg=new int[n];
        for(int i=0;i<pre.length;i++){
            int u=pre[i][0];
            int v=pre[i][1];
            g[v].add(u);
            indeg[u]++;
        }
        Queue<Integer> q=new LinkedList<>();
        int start=0;
        boolean[] vis=new boolean[n];
        boolean f=true;
        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                q.add(i);
                f=false;
                vis[i]=true;
                
            }
        }
        
        while(!q.isEmpty()){
            int cur=q.poll();
            
            for(int x:g[cur]){
                indeg[x]--;
                if(!vis[x]&&indeg[x]==0){
                    q.add(x);
                    vis[x]=true;
                    
                }
                
                
                
            }
        }
        boolean b=true;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                return false;
            }
        }
        return true;
        


        
    }
}