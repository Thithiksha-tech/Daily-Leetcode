class Solution {
    public int minMutation(String start, String end, String[] bank) {
        char[] dna={'A','C','G','T'};
        HashSet<String> banks=new HashSet<>();
        for(String s:bank){
            banks.add(s);

        }
        Queue<String> q=new LinkedList<>();
        HashSet<String> set=new HashSet<>();
        q.add(start);
        set.add(start);
        if(start.equals(end)){
            return 0;
        }
        int steps=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int j=0;j<size;j++){
                String cur=q.poll();
                if(cur.equals(end)){
                    return steps;
                }
                char[] ch=cur.toCharArray();
                for(int i=0;i<ch.length;i++){
                    char ori=ch[i];
                    for(int k=0;k<dna.length;k++){
                        ch[i]=dna[k];
                        String next=new String(ch);
                        if(banks.contains(next)&&!set.contains(next)){
                            q.add(next);
                            set.add(next);
                        }
                    }
                    ch[i]=ori;
                }
                
            }
            steps++;
        }
        return -1;
        
    }
}