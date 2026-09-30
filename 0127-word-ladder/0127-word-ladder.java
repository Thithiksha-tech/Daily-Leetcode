class Solution {
    public static int bfs(String a, String e, HashSet<String> l,Queue<String> q, Set<String> vis) {

    int steps = 1;

    while(!q.isEmpty()) {

        int size = q.size();

        for(int k = 0; k < size; k++) {

            String cur = q.poll();

            if(cur.equals(e)) {
                return steps;
            }

            for(int i = 0; i < cur.length(); i++) {

                char[] arr = cur.toCharArray();

                for(char c = 'a'; c <= 'z'; c++) {

                    if(c == cur.charAt(i))
                        continue;

                    arr[i] = c;

                    String next = new String(arr);

                    if(l.contains(next) && !vis.contains(next)) {
                        q.add(next);
                        vis.add(next);
                    }
                }
            }
        }

        steps++;
    }

    return 0;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q=new LinkedList<>(); Set<String> vis=new HashSet<>(); 
        q.add(beginWord); 
        vis.add(beginWord);
        HashSet<String> words = new HashSet<>(wordList);
        return bfs(beginWord,endWord,words,q,vis);
        
    }
}