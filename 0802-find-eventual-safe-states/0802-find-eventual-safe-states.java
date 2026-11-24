class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] arr=new ArrayList[n+1];
        for(int i=0;i<n;i++){
            arr[i]=new ArrayList<>();
        }
        int[] deg=new int[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                arr[graph[i][j]].add(i);
                deg[i]++;

            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(deg[i]==0){
                q.add(i);
               
                
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            ans.add(curr);
            for(int x:arr[curr]){
                deg[x]--;
                if(deg[x]==0){
                    q.add(x);
                }
            }
        }
        
        Collections.sort(ans);
        return ans;
        
        

        
    }
}