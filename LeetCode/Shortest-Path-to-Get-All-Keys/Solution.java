1class Solution {
2
3    static int[] dr = {-1, 1, 0, 0};
4    static int[] dc = {0, 0, -1, 1};
5
6    static class State {
7        int r;
8        int c;
9        int mask;
10
11        State(int r, int c, int mask) {
12            this.r = r;
13            this.c = c;
14            this.mask = mask;
15        }
16    }
17
18    public int shortestPathAllKeys(String[] grid) {
19
20        int m = grid.length;
21        int n = grid[0].length();
22
23        int sr = 0;
24        int sc = 0;
25        int keycount = 0;
26
27        for(int i = 0; i < m; i++) {
28            for(int j = 0; j < n; j++) {
29
30                char ch = grid[i].charAt(j);
31
32                if(ch == '@') {
33                    sr = i;
34                    sc = j;
35                }
36
37                if(ch >= 'a' && ch <= 'f') {
38                    keycount++;
39                }
40            }
41        }
42
43        int all = (1 << keycount) - 1;
44
45        boolean[][][] vis =
46            new boolean[m][n][1 << keycount];
47
48        Queue<State> q = new LinkedList<>();
49
50        q.add(new State(sr, sc, 0));
51        vis[sr][sc][0] = true;
52
53        int steps = 0;
54
55        while(!q.isEmpty()) {
56
57            int size = q.size();
58
59            for(int k = 0; k < size; k++) {
60
61                State cur = q.poll();
62
63                int r = cur.r;
64                int c = cur.c;
65                int mask = cur.mask;
66
67                if(mask == all) {
68                    return steps;
69                }
70
71                for(int j = 0; j < 4; j++) {
72
73                    int nx = r + dr[j];
74                    int ny = c + dc[j];
75
76                    if(nx < 0 || nx >= m ||
77                       ny < 0 || ny >= n) {
78                        continue;
79                    }
80
81                    char ch = grid[nx].charAt(ny);
82
83                    // Wall
84                    if(ch == '#') {
85                        continue;
86                    }
87
88                    // Lock
89                    if(ch >= 'A' && ch <= 'F') {
90
91                        int key = ch - 'A';
92
93                        if((mask & (1 << key)) == 0) {
94                            continue;
95                        }
96                    }
97
98                    int nmask = mask;
99
100                    // Key
101                    if(ch >= 'a' && ch <= 'f') {
102
103                        int key = ch - 'a';
104
105                        nmask = mask | (1 << key);
106                    }
107
108                    // Add EVERY valid cell
109                    if(!vis[nx][ny][nmask]) {
110
111                        vis[nx][ny][nmask] = true;
112
113                        q.offer(
114                            new State(nx, ny, nmask)
115                        );
116                    }
117                }
118            }
119
120            steps++;
121        }
122
123        return -1;
124    }
125}