class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        int arrowPos = points[0][1];
        int cnt = 1;

        for(int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {
                continue;
            }
            cnt++;
            arrowPos = points[i][1];
        }

        return cnt;
    }
}