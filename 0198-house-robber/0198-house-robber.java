class Solution {
    public int rob(int[] nums) {

        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }

        int[] answer = new int[nums.length];
        answer[0] = nums[0];
        answer[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++){
            answer[i] = Math.max(answer[i-2] + nums[i], answer[i-1]);
        }

        return answer[nums.length - 1];
    }
}