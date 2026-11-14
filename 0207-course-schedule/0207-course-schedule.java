class Solution {
    public boolean canFinish(int n, int[][] pre) {
        int[][] g=new int[n][n];
        int[] indeg=new int[n];
        for(int i=0;i<pre.length;i++){
            int u=pre[i][0];
            int v=pre[i][1];
            g[v][u]=1;
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
            
            for(int i=0;i<n;i++){
                if(g[cur][i]==1){
                    indeg[i]--;
                }
                if(!vis[i]&&indeg[i]==0){
                    q.add(i);
                    vis[i]=true;
                    
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