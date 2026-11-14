class Solution {
    public int shortestPathLength(int[][] g) {
       
        int n=g.length;

        boolean[][] vis=new boolean[n][1<<n];
        Queue<int[]> q=new LinkedList<>();

        int allvis=(1<<n)-1;
        for(int i=0;i<n;i++){
            int mask=1<<i;
            q.add(new int[]{i,mask,0});
            vis[i][mask]=true;

        }
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int mask=cur[1];
            int steps=cur[2];
            int node=cur[0];
            if(mask==allvis){
                return steps;
            }
            for(int x:g[node]){
                int nmask=mask;
                nmask|=(1<<x);
                if(!vis[x][nmask]){
                    vis[x][nmask]=true;
                    q.add(new int[]{x,nmask,steps+1});
                }
            }


        }
        return -1;

        
    }
}