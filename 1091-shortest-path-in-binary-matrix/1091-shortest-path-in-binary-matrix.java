import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        int[][] dirs = {
            {-1,-1}, {-1,0}, {-1,1},
            {0,-1},          {0,1},
            {1,-1},  {1,0},  {1,1}
        };

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1});

        grid[0][0] = 1; // visited

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int row = cur[0];
            int col = cur[1];
            int dist = cur[2];

            if (row == n - 1 && col == n - 1) {
                return dist;
            }

            for (int[] d : dirs) {

                int nr = row + d[0];
                int nc = col + d[1];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    grid[nr][nc] == 0) {

                    grid[nr][nc] = 1;

                    q.offer(new int[]{
                        nr,
                        nc,
                        dist + 1
                    });
                }
            }
        }

        return -1;
    }
}