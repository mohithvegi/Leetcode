// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3785/

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, grid[0][0]});

        int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0], y = curr[1], value = curr[2];
            if (x == n - 1 && y == n - 1) {
                return value;
            }
            // Ignore processed nodes
            if (visited[x][y]) {
                continue;
            }
            // Attention Here !!!
            // record the position and distance (the position node has been pop from the priority queue)
            visited[x][y] = true;

            for (int[] dir : DIRS) {
                int nextX = x + dir[0], nextY = y + dir[1];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || visited[nextX][nextY]) {
                    continue;
                }
                pq.offer(new int[]{nextX, nextY, Math.max(value, grid[nextX][nextY])});
            }
        }

        return -1;
    }
}
