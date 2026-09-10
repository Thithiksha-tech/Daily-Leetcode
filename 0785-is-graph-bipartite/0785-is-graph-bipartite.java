class Solution {
    public boolean isBipartite(int[][] g) {
        int n=g.length;
        int[] color=new int[n];
        for(int i=0;i<n;i++){
            if(color[i]!=0){
                continue;
            }
            Queue<Integer> q=new LinkedList<>();
            color[i]=1;
            q.add(i);
            while(!q.isEmpty()){
                int node=q.poll();
                for(int e:g[node]){
                    if(color[e]==0){
                        color[e]=3-color[node];
                        q.add(e);
                    }
                    else if(color[e]==color[node]){
                        return false;
                        
                    }
                }
            }
        }
        return true;
    }
}