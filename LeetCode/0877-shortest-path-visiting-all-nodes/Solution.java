class Solution {
    public int shortestPathLength(int[][] g) {
      
        int n=g.length;
        Queue<int[]> q=new LinkedList<>();
        int allvis=(1<<n)-1;
        boolean[][] vis=new boolean[n][1<<n];
        for (int i = 0; i < n; i++) {
            int mask = (1 << i);  // Mark starting node i as visited

            q.add(new int[]{i, mask, 0});
            vis[i][mask] = true;
        }
        while(!q.isEmpty()){
            int[] node=q.poll();
            int cur=node[0];
            int nmask=node[1];
            int steps=node[2];
            if(nmask==allvis){
                return steps;
            }
            for(int x:g[cur]){
               int newmask=nmask;
                newmask|=(1<<x);
                if(!vis[x][newmask]){
                    vis[x][newmask]=true;
                    q.add(new int[]{x,newmask,steps+1});
                }
            }
        }
        return -1;
    }
}