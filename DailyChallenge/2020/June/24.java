// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3790/

class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        if (N <= 0) {
            return 0;
        }

        final int MOD = 1000000007;
        int[][] dp = new int[m][n];
        for (int row = 0; row < m; row++) {
            dp[row][0]++;
            dp[row][n - 1]++;
        }
        for (int col = 0; col < n; col++) {
            dp[0][col]++;
            dp[m - 1][col]++;
        }

        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for (int k = 2; k <= N; k++) {
            int[][] dp2 = new int[m][n];
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    for (int[] dir : dirs) {
                        int nextRow = row + dir[0];
                        int nextCol = col + dir[1];
                        if (outOfBounds(m, n, nextRow, nextCol)) {
                            dp2[row][col] = (dp2[row][col] + 1) % MOD;
                        } else {
                            dp2[row][col] = (dp2[row][col] + dp[nextRow][nextCol]) % MOD;
                        }
                    }
                }
            }
            dp = dp2;
        }

        return dp[i][j];
    }

    private boolean outOfBounds(int m, int n, int row, int col) {
        return row < 0 || row >= m || col < 0 || col >= n;
    }
}
