1class Solution {
2    
3    public static int bfs(HashSet<String> dead,String target,Queue<String> q,HashSet<String> vis){
4        int steps=0;
5        while(!q.isEmpty()){
6            int size=q.size();
7
8            for(int k=0;k<size;k++){
9                String cur=q.poll();
10                if(cur.equals(target)){
11                    return steps;
12                }
13                for(int i=0;i<4;i++){
14                    char[] arr=cur.toCharArray();
15                    arr[i]=(char)((arr[i]-'0'+1)%10+'0');
16                    String next=new String(arr);
17                    if(!dead.contains(next)&&!vis.contains(next)){
18                        q.add(next);
19                        vis.add(next);
20                    }
21                    arr=cur.toCharArray();
22                     arr[i]=(char)((arr[i]-'0'+9)%10+'0');
23                    next=new String(arr);
24                    if(!dead.contains(next)&&!vis.contains(next)){
25                        q.add(next);
26                        vis.add(next);
27                    }
28                    
29
30                }
31            }
32            steps++;
33        }
34        return -1;
35    }
36    public int openLock(String[] deadends, String target) {
37        
38        Queue<String> q=new LinkedList<>();
39        HashSet<String> vis=new HashSet<>();
40        HashSet<String> dead=new HashSet<>();
41        for(String s:deadends){
42            dead.add(s);
43        }
44        String st="0000";
45        if(dead.contains("0000")){
46            return -1;
47        }
48
49        q.add(st);
50        vis.add(st);
51        return bfs(dead,target,q,vis);
52        
53    }
54}