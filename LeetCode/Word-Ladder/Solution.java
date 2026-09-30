1class Solution {
2    public static int bfs(String a, String e, HashSet<String> l,Queue<String> q, Set<String> vis) {
3
4    int steps = 1;
5
6    while(!q.isEmpty()) {
7
8        int size = q.size();
9
10        for(int k = 0; k < size; k++) {
11
12            String cur = q.poll();
13
14            if(cur.equals(e)) {
15                return steps;
16            }
17
18            for(int i = 0; i < cur.length(); i++) {
19
20                char[] arr = cur.toCharArray();
21
22                for(char c = 'a'; c <= 'z'; c++) {
23
24                    if(c == cur.charAt(i))
25                        continue;
26
27                    arr[i] = c;
28
29                    String next = new String(arr);
30
31                    if(l.contains(next) && !vis.contains(next)) {
32                        q.add(next);
33                        vis.add(next);
34                    }
35                }
36            }
37        }
38
39        steps++;
40    }
41
42    return 0;
43    }
44    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
45        Queue<String> q=new LinkedList<>(); Set<String> vis=new HashSet<>(); 
46        q.add(beginWord); 
47        vis.add(beginWord);
48        HashSet<String> words = new HashSet<>(wordList);
49        return bfs(beginWord,endWord,words,q,vis);
50        
51    }
52}