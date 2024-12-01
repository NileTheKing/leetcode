class Solution {
    public int numTilings(int n) {
        if(n <= 2){
            return n;
        }
        int[] dp =  new int[n + 1];

        int mod = 1_000_000_007;
    
        //dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        for (int i = 4; i <= n; i++) { // i <= n으로 변경
            dp[i] = (2 * dp[i - 1] % mod + dp[i - 3]) % mod; // 점화식 수정
        }

        return dp[n];
    }
}
/**
만약 n이 3이라면 dp는 3개를 담을 수 있는 배열이여야 함.
그걸 채우려면
 */