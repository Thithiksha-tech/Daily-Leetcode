class Solution {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class State {
        int r;
        int c;
        int mask;

        State(int r, int c, int mask) {
            this.r = r;
            this.c = c;
            this.mask = mask;
        }
    }

    public int shortestPathAllKeys(String[] grid) {

        int m = grid.length;
        int n = grid[0].length();

        int sr = 0;
        int sc = 0;
        int keycount = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                char ch = grid[i].charAt(j);

                if(ch == '@') {
                    sr = i;
                    sc = j;
                }

                if(ch >= 'a' && ch <= 'f') {
                    keycount++;
                }
            }
        }

        int all = (1 << keycount) - 1;

        boolean[][][] vis =
            new boolean[m][n][1 << keycount];

        Queue<State> q = new LinkedList<>();

        q.add(new State(sr, sc, 0));
        vis[sr][sc][0] = true;

        int steps = 0;

        while(!q.isEmpty()) {

            int size = q.size();

            for(int k = 0; k < size; k++) {

                State cur = q.poll();

                int r = cur.r;
                int c = cur.c;
                int mask = cur.mask;

                if(mask == all) {
                    return steps;
                }

                for(int j = 0; j < 4; j++) {

                    int nx = r + dr[j];
                    int ny = c + dc[j];

                    if(nx < 0 || nx >= m ||
                       ny < 0 || ny >= n) {
                        continue;
                    }

                    char ch = grid[nx].charAt(ny);

                    // Wall
                    if(ch == '#') {
                        continue;
                    }

                    // Lock
                    if(ch >= 'A' && ch <= 'F') {

                        int key = ch - 'A';

                        if((mask & (1 << key)) == 0) {
                            continue;
                        }
                    }

                    int nmask = mask;

                    // Key
                    if(ch >= 'a' && ch <= 'f') {

                        int key = ch - 'a';

                        nmask = mask | (1 << key);
                    }

                    // Add EVERY valid cell
                    if(!vis[nx][ny][nmask]) {

                        vis[nx][ny][nmask] = true;

                        q.offer(
                            new State(nx, ny, nmask)
                        );
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}