class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> q=new LinkedList<>();
        Set<String> vis=new HashSet<>();
        Set<String> dead=new HashSet<>(Arrays.asList(deadends));
        String st="0000";
        if(dead.contains(st)){
            return -1;
        }
        q.add("0000");
        vis.add("0000");
        int steps=0;

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String str=q.poll();
                if(str.equals(target)){
                    return steps;
                }
                
                for(int j=0;j<4;j++){
                    char[] arr=str.toCharArray();
                    arr[j]=(char)((arr[j]-'0'+1)%10+'0');
                    String next=new String(arr);
                    if(!vis.contains(next)&&!dead.contains(next)){
                        q.add(next);
                        vis.add(next);

                    }
                    arr=str.toCharArray();
                    arr[j]=(char)((arr[j]-'0'+9)%10+'0');
                    String prev=new String(arr);
                    if(!vis.contains(prev)&&!dead.contains(prev)){
                        q.add(prev);
                        vis.add(prev);

                    }

                }
            }
            steps++;
        }
        return -1;
        
    }
}