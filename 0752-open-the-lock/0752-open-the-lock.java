class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> deads=new HashSet<>();
        HashSet<String> set=new HashSet<>();
        for(String x:deadends){
            deads.add(x);
        }
        if(deads.contains(target)){
            return -1;

        }
        Queue<String> q=new LinkedList<>();
        q.add("0000");
        set.add("0000");
        if(deads.contains("0000")){
            return -1;
        }
        int steps=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int j=0;j<size;j++){
                String cur=q.poll();
                if(cur.equals(target)){
                    return steps;
                }
                char[] ch=cur.toCharArray();
                for(int i=0;i<ch.length;i++){
                    char ori=ch[i];
                    
                        ch[i]=(char)(((ch[i]-'0'+1)%10)+'0');
                        String up=new String(ch);
                        if(!deads.contains(up)&&!set.contains(up)){
                            q.add(up);
                            set.add(up);
                        }
                        ch[i]=ori;
                        ch[i]=(char)(((ch[i]-'0'+9)%10)+'0');
                        String down=new String(ch);
                        if(!deads.contains(down)&&!set.contains(down)){
                            q.add(down);
                            set.add(down);
                        }

                    
                    ch[i]=ori;
                }
            }
            steps++;
           
        }
        return -1;
        
    }
}