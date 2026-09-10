1class Solution {
2    public boolean possibleBipartition(int n, int[][] d) {
3       
4        List<List<Integer>> g=new ArrayList<>();
5        for(int i=0;i<=n;i++){
6            g.add(new ArrayList<>());
7        }
8        for(int[] e:d){
9            int u=e[0];
10            int v=e[1];
11            g.get(u).add(v);
12            g.get(v).add(u);
13        }
14        int[] color=new int[n+1];
15        for(int i=1;i<=n;i++){
16            //component
17            if(color[i]!=0){
18                continue;
19            }
20            Queue<Integer> q=new LinkedList<>();
21            color[i]=1;
22            q.add(i);
23            while(!q.isEmpty()){
24                int node=q.poll();
25                for(int nei:g.get(node)){
26                    if(color[nei]==0){
27                        color[nei]=3-color[node];
28
29                        q.add(nei);
30
31                    }
32                    else if(color[nei]==color[node]){
33                        return false;
34
35                    }
36                }
37            }
38        }
39        return true;
40        
41    }
42}