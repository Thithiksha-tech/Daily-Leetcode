class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>();
        for(String s:wordList){
            set.add(s);
        }
        if(!set.contains(endWord)){
            return 0;
        }
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        int steps=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int j=0;j<size;j++){
                String word=q.poll();
                if(word.equals(endWord)){
                    return steps;
                }
                char[] ch=word.toCharArray();
                for(int i=0;i<ch.length;i++){
                    char ori=ch[i];
                    for(char c='a';c<='z';c++){
                        ch[i]=c;
                        String next=new String(ch);
                        if(set.contains(next)){
                            q.add(next);
                            set.remove(next);
                        }
                    }
                    ch[i]=ori;
                }
                
            }
            steps++;
            
        }
        return 0;
    }
}