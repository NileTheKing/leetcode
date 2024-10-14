class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0;
        int end = 0;
        int zero = 0;


        while(end < nums.length){
            if(nums[end] == 0){
                zero++;
            }
            end++;
            if(zero > 1){
                if(nums[start] == 0){
                    zero--;
                }
                start++;
            }
        }


        return end - start - 1;
    }
}