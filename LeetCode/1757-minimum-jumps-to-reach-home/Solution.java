import java.util.*;

class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {

        int max = x;

        for (int v : forbidden) {
            max = Math.max(max, v);
        }

        int maxlim = max + a + b;

        Set<Integer> set = new HashSet<>();
        for (int v : forbidden) {
            set.add(v);
        }

        // State: {position, lastBackward}
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[maxlim + 1][2];

        q.add(new int[]{0, 0});
        vis[0][0] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int k = 0; k < size; k++) {
                int[] state = q.poll();

                int cur = state[0];
                int lastBackward = state[1];

                if (cur == x) {
                    return steps;
                }

                // Forward jump
                int forward = cur + a;

                if (forward <= maxlim
                    && !set.contains(forward)
                    && !vis[forward][0]) {

                    vis[forward][0] = true;
                    q.add(new int[]{forward, 0});
                }

                // Backward jump: previous jump must not be backward
                int backward = cur - b;

                if (lastBackward == 0
                    && backward >= 0
                    && !set.contains(backward)
                    && !vis[backward][1]) {

                    vis[backward][1] = true;
                    q.add(new int[]{backward, 1});
                }
            }

            steps++;
        }

        return -1;
    }
}