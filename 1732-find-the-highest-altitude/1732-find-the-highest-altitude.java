class Solution {
    public int largestAltitude(int[] gain) {
        int sum = 0;
        int maxSum = 0;

        //배열 순회
        for(int i = 0; i < gain.length; i++){
            sum += gain[i]; //net altitude 구하기
            if(maxSum <= sum) //최고지점 찾아야 하므로 비교
                maxSum = sum;
        }
        return maxSum;
    }
}
