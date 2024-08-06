class Solution {
    public int[] countBits(int n) {
        
        int[] ans = new int[n+1];
        for(int i = 0; i <= n; i++){
            //i를 2진수로 변환
            //이후 1을 카운팅
            //카운팅 한 것을 ans에 저장
            String binaryString = Integer.toBinaryString(i);
            int count = 0;
            for(int j = 0 ; j < binaryString.length(); j++)
                if(binaryString.charAt(j) == '1')
                    count++;
            ans[i] = count;
        }
        return ans;
    }
}