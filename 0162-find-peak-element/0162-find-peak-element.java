class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int n = nums.length;
        if(nums[0] > nums[1]) return 0;
        if(nums[n - 1] > nums[n - 2]) return n - 1;

        int first = 1;
        int last = n - 2;
        int mid;

        while(first <= last) {
            mid = first + (last - first) / 2;
            if(nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]){
                return mid;
            }
            else if(nums[mid - 1] > nums[mid]) {
                last = mid -1;
            }
            else if(nums[mid + 1] > nums[mid]) {
                first = mid + 1;
            }
        }
        return -1;
    }
}