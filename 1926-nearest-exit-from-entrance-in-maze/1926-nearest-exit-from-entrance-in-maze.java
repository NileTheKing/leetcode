import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int columns = maze[0].length;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(entrance[0], entrance[1]));

        // 시작 지점을 방문한 것으로 표시
        maze[entrance[0]][entrance[1]] = '+';

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                Point current = queue.poll();

                // 상하좌우 이동만 고려
                int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                for (int[] direction : directions) {
                    int newX = current.x + direction[0];
                    int newY = current.y + direction[1];

                    // 유효한 위치인지 확인
                    if (newX < 0 || newX >= rows || newY < 0 || newY >= columns)
                        continue;
                    if (maze[newX][newY] == '+')
                        continue;

                    // 출구 확인
                    if (newX == 0 || newX == rows - 1 || newY == 0 || newY == columns - 1)
                        return steps;

                    // 방문 표시 및 큐에 추가
                    maze[newX][newY] = '+';
                    queue.add(new Point(newX, newY));
                }
            }
        }

        return -1;
    }
}
