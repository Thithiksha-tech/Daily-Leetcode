class Solution {
    public static void dfs(int node,ArrayList<Integer>[] a,int n,boolean[] vis){
        vis[node]=true;
        for(int nei:a[node]){
            if(!vis[nei]){
                dfs(nei,a,n,vis);
            }
        }
        
    }
    public int findCircleNum(int[][] c) {
        int count=0;
        int n=c.length;
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] a=new ArrayList[n+1];
        for(int i=0;i<c.length;i++){
            a[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j&&c[i][j]==1){
                    a[i].add(j);
                }
            }
        }
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,a,n,vis);
                count++;
            }
            
        }
        return count;
        
    }
}