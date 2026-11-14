class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        @SuppressWarnings("unchecked")

        ArrayList<Integer>[] g=new ArrayList[n+1];
        for(int i=0;i<n;i++){
            g[i]=new ArrayList<>();
        }
        int[] outdeg=new int[n];
        for(int i=n-1;i>=0;i--){
            for(int x:graph[i]){
                g[x].add(i);
                outdeg[i]++;
            }
        }
        
        ArrayList<Integer> topo=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=n-1;i>=0;i--){
            if(outdeg[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int cur=q.poll();
            topo.add(cur);
            for(int x:g[cur]){
                outdeg[x]--;
                if(outdeg[x]==0){
                    q.add(x);
                }
            }
        }
        Collections.sort(topo);
        // for(int i=topo.size()-1;i>=0;i--){
        //     ans.add(topo.get(i));

        // }
        return topo;

        
    }
}