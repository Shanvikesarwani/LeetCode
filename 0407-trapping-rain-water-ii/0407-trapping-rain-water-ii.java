
class Solution {
    public int trapRainWater(int[][] heightMap) {

        int m = heightMap.length;
        int n = heightMap[0].length;

        if (m < 3 || n < 3) return 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[2] - b[2]
        );

        boolean[][] visited = new boolean[m][n];

        
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n-1, heightMap[i][n-1]});

            visited[i][0] = true;
            visited[i][n-1] = true;
        }

        for (int j = 1; j < n-1; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{m-1, j, heightMap[m-1][j]});

            visited[0][j] = true;
            visited[m-1][j] = true;
        }

        int water = 0;

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int r = curr[0];
            int c = curr[1];
            int h = curr[2];

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    !visited[nr][nc]) {

                    visited[nr][nc] = true;

                    water += Math.max(
                        0, h - heightMap[nr][nc]
                    );

                    int newHeight = Math.max(
                        h, heightMap[nr][nc]
                    );

                    pq.offer(new int[]{
                        nr, nc, newHeight
                    });
                }
            }
        }

        return water;
    }
}
