class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist=new int[n][n];
        int INF=1000000000;
        for(int[] x:dist){
            Arrays.fill(x,INF);
        }

        for(int i=0;i<n;i++){
            dist[i][i]=0;
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            dist[u][v]=w;
            dist[v][u]=w;
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]!=INF&&dist[k][j]!=INF){
                        dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }
                }
            }
        }
        int count=0;
        int max=0;
        int mincount=INF;
        for(int i=0;i<n;i++){
            count=0;
            for(int j=0;j<n;j++){
                if(dist[i][j]<=distanceThreshold&&i!=j){
                    count++;
                    
                    
                }
            }
            if(count<=mincount){
                max=i;
                mincount=count;
            }

            
        }
        return max;
    }
}