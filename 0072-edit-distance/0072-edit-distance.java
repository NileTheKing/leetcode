class Solution {
    public int minDistance(String word1, String word2) {
        int rows = word2.length() + 1;
        int cols = word1.length() + 1;

        int[][] dp = new int[rows][cols];

        for(int i = 0; i < rows; i++){
            dp[i][0] = i;
        }

        for(int j = 0; j < cols; j++){
            dp[0][j] = j;
        }

        for(int i = 1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                if(word1.charAt(j - 1) == word2.charAt(i - 1)) dp[i][j] = dp[i-1][j-1];
                else{
                    dp[i][j] = Math.min(dp[i-1][j-1] + 1
                    , Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1));
                }
            }
        }

        return dp[rows - 1][cols - 1];
    }
}