class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;//left:0이 아닌 숫자가 있는 인덱스 right:현잭 검사 중인 인덱스
        while (right < nums.length) {//검사 마칠때까지
            if (nums[right] != 0) {
                nums[left++] = nums[right++];//검사 중인 숫자를 왼쪽으로 밀어넣고 각각 증가
            } else {
                right++;
            }
        }
			//마지막으로 찾은 0이아닌 숫자 인덱스 이후로 0으로 채움
 
        while (left < nums.length) {            nums[left++] = 0;
        }
    }
}
