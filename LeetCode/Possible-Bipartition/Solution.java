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
15        //BFS FOR EVERY
16        for(int i=1;i<=n;i++){
17            //component
18            if(color[i]!=0){
19                continue;
20            }
21            Queue<Integer> q=new LinkedList<>();
22            color[i]=1;
23            q.add(i);
24            while(!q.isEmpty()){
25                int node=q.poll();
26                for(int nei:g.get(node)){
27                    if(color[nei]==0){
28                        color[nei]=3-color[node];
29
30                        q.add(nei);
31
32                    }
33                    else if(color[nei]==color[node]){
34                        return false;
35
36                    }
37                }
38            }
39        }
40        return true;
41        
42    }
43}