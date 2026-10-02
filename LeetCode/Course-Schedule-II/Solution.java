1class Solution {
2    public int[] findOrder(int n, int[][] p) {
3        int[] topo=new int[n];
4        @SuppressWarnings("unchecked")
5        ArrayList<Integer>[] arr=new ArrayList[n];
6        for(int i=0;i<n;i++){
7            arr[i]=new ArrayList<>();
8        }
9        int[] indeg=new int[n];
10        for(int i=0;i<p.length;i++){
11            int a=p[i][0];
12            int b=p[i][1];
13            arr[b].add(a);
14            indeg[a]++;
15            
16        }
17        int index=0;
18        Queue<Integer> q=new LinkedList<>();
19        boolean f=false;
20        for(int i=0;i<n;i++){
21            if(indeg[i]==0){
22                q.add(i);
23                f=true;
24               
25            }
26        }
27        
28        
29        
30            while(!q.isEmpty()){
31                int cur=q.poll();
32                topo[index++]=cur;
33                for(int u:arr[cur]){
34                    indeg[u]--;
35                    if(indeg[u]==0){
36                        q.add(u);
37                    }
38                        
39
40                }
41            }
42        
43        
44        if(index!=n){
45            return new int[]{};
46        }
47        return topo;
48    }
49}