class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;

        int[] dp = new int[n];

        for (int j = 0; j < n; j++) {
            dp[j] = grid[0][j];
        }

        for (int i = 1; i < n; i++) {

            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            int minCol = -1;

            for (int j = 0; j < n; j++) {
                if (dp[j] < min1) {
                    min2 = min1;
                    min1 = dp[j];
                    minCol = j;
                } else if (dp[j] < min2) {
                    min2 = dp[j];
                }
            }

            int[] curr = new int[n];

            for (int j = 0; j < n; j++) {
                if (j == minCol) {
                    curr[j] = grid[i][j] + min2;
                } else {
                    curr[j] = grid[i][j] + min1;
                }
            }

            dp = curr;
        }

        int ans = Integer.MAX_VALUE;

        for (int x : dp) {
            ans = Math.min(ans, x);
        }

        return ans;
    }
}