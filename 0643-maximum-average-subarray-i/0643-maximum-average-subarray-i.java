class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        //초기 평균값 구하기
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max = sum;
        for(int i = k; i < nums.length; i++) {
            sum = sum - nums[i-k] + nums[i]; //슬라이딩윈도우. 하나 빼고 하나 넣음.
            max = Math.max(max, sum); //현재 최고랑 비교
        }

        return (double)max/k;
    }
}