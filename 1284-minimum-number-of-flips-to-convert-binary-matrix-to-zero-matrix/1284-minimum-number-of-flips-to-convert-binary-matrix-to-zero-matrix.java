class Solution {

    public int minFlips(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int start = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    start |= (1 << (i * cols + j));
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[512];

        queue.offer(start);
        visited[start] = true;

        int flips = 0;

        int[][] dir = {
            {0,0},
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                int mask = queue.poll();

                if (mask == 0)
                    return flips;

                for (int i = 0; i < rows; i++) {

                    for (int j = 0; j < cols; j++) {

                        int next = mask;

                        for (int[] d : dir) {

                            int nr = i + d[0];
                            int nc = j + d[1];

                            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                                next ^= (1 << (nr * cols + nc));
                            }
                        }

                        if (!visited[next]) {
                            visited[next] = true;
                            queue.offer(next);
                        }
                    }
                }
            }

            flips++;
        }

        return -1;
    }
}