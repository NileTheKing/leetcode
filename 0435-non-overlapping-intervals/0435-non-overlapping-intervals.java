class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // 구간을 끝점을 기준으로 정렬.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int end = intervals[0][1]; // 첫 번째 구간의 끝점을 초기값으로 설정

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) { // 겹치는 경우
                count++; // 제거해야 하는 구간 수 증가
            } else {
                end = intervals[i][1]; // 겹치지 않으면 end 업데이트
            }
        }

        return count;
    }
}