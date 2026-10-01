class Solution {
    
    public static int bfs(HashSet<String> dead,String target,Queue<String> q,HashSet<String> vis){
        int steps=0;
        while(!q.isEmpty()){
            int size=q.size();

            for(int k=0;k<size;k++){
                String cur=q.poll();
                if(cur.equals(target)){
                    return steps;
                }
                for(int i=0;i<4;i++){
                    char[] arr=cur.toCharArray();
                    arr[i]=(char)((arr[i]-'0'+1)%10+'0');
                    String next=new String(arr);
                    if(!dead.contains(next)&&!vis.contains(next)){
                        q.add(next);
                        vis.add(next);
                    }
                    arr=cur.toCharArray();
                     arr[i]=(char)((arr[i]-'0'+9)%10+'0');
                    next=new String(arr);
                    if(!dead.contains(next)&&!vis.contains(next)){
                        q.add(next);
                        vis.add(next);
                    }
                    

                }
            }
            steps++;
        }
        return -1;
    }
    public int openLock(String[] deadends, String target) {
        
        Queue<String> q=new LinkedList<>();
        HashSet<String> vis=new HashSet<>();
        HashSet<String> dead=new HashSet<>();
        for(String s:deadends){
            dead.add(s);
        }
        String st="0000";
        if(dead.contains("0000")){
            return -1;
        }

        q.add(st);
        vis.add(st);
        return bfs(dead,target,q,vis);
        
    }
}