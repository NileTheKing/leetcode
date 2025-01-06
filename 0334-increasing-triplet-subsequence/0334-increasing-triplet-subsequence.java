class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;

        int small = Integer.MAX_VALUE;
        int large = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > large ) {
                return true; // small < nums[i] < large
            }
            else if (nums[i] <= small) {
                small = nums[i]; // 가장 작은 값 갱신
            }
            else if (nums[i] < large) {
                large = nums[i]; // 뒤에서 오는 최댓값 갱신
            }
        }

        return false;
    }
}
