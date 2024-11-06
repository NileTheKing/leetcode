class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>(); // Queue to store coordinates of initially rotten oranges

        int minute = 0;
        int count = 0;
        int[][] directions = {{0,1}, {-1,0}, {0,-1}, {1,0}}; // Right, Up, Left, Down
        int rowLength = grid.length;
        int colLength = grid[0].length;

        // Count fresh oranges and add initially rotten oranges to the queue before the first iteration
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        // Process each minute by spreading rot to adjacent fresh oranges
        while (!q.isEmpty()) {
            int qSize = q.size();
            boolean rottenThisTime = false;

            // Spread rot to adjacent fresh oranges
            for (int i = 0; i < qSize; i++) {
                int[] coord = q.poll();
                for (var direction : directions) { // Check adjacent coordinates
                    int nx = coord[0] + direction[0];
                    int ny = coord[1] + direction[1];

                    // Skip invalid coordinates (out of grid bounds)
                    if (nx < 0 || nx >= rowLength || ny < 0 || ny >= colLength) {
                        continue;
                    } else if (grid[nx][ny] == 1) {
                        grid[nx][ny] = 2; 
                        rottenThisTime = true;
                        q.offer(new int[] {nx, ny}); 
                        count--; 
                    }
                }
            }

            // Only increment time if any oranges were newly rotten in this minute
            if (rottenThisTime) {
                minute++;
            }
        }

        return count == 0 ? minute : -1;
    }
}
