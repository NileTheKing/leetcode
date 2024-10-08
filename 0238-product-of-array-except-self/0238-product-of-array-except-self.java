class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;

        int[] prefixSum = new int[size];
        int[] suffixSum = new int[size];

        int[] ans = new int[size];


        //suffixSum과 prefixSum 배열의 값을 완성시킨다. -fixSum[i]은 nums[i]을 제외한 앞, 뒤 모든 곱의 값과 동일
        //prefixSum[]은 nums인덱스 기준 0은 0이고 1부터 마지막 인덱스까지 값을 가진다
        //suffixSum[]은 nums인덱스 기준 마지막인덱스는 0이고 마지막 인덱스 전부터 맨 처음 인덱스까지 값을 가진다.

        prefixSum[0] = 1;
        suffixSum[size -1] = 1;
        for(int i = 1; i < size; i++){
            prefixSum[i] = prefixSum[i - 1] * nums[i - 1];
            //ex prefixSum[2]는 1의 prefix와 nums[1]임.
            //i = 2가정
            suffixSum[size - 1  -i] = suffixSum[size - 1 - i + 1]  * nums[size - 1 - i + 1];
            //suffixsum[맨마지막에서 세번째] = suffixSum[맨마지막에서 두번쨰] * nums[맨마지막에서 두번째]
        }
        //맨 마지막 i에 대해 suffixSum은 suffixSum[size -1 - size +1]=suffixSum[0] =suffixSum[1] * nums[1]

    
        

        for(int i = 0; i < size; i++){
            ans[i] = prefixSum[i] * suffixSum[i];
        }

        return ans;
    }
}
/**
0으로 나누면 안됨 

인덱스0 1 2 3 4
값   1 2 3 4 5 //5부터 순회하여야 하므로 i가 0일떄 인덱스 초기값은 length

prefixSum[0]은 존재하지 않음
suffixSum[length -1]은 존재하지 않음.
*/