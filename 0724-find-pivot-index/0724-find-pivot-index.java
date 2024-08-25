class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        // 전체 합계 계산
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        int left = 0; // 왼쪽 합계 초기화

        for (int i = 0; i < nums.length; i++) {
            // 피벗 인덱스 조건
            if (left * 2 + nums[i] == sum) {
                return i; // 피벗 인덱스 반환
            }
            left += nums[i]; // 왼쪽 합계 업데이트
        }
        
        return -1; // 피벗 인덱스가 없는 경우 -1 반환
    }
}
