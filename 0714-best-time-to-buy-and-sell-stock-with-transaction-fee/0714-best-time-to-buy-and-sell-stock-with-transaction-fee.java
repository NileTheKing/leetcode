class Solution {
    public int maxProfit(int[] prices, int fee) {
        
        int buy = Integer.MIN_VALUE;
        int sell = 0;

        for (int price : prices) {

            //샀을 때의 순이익
            buy = Math.max(buy, sell - price);

            //팔 때의 순이익. 버티거나 팔거ㅏㄴ
            sell = Math.max(sell, buy + price - fee);
        }

        return sell;
    }
}
/**
최댓값. 1. 백트래킹 2. dp

1차원 or 2차원
    1차원: 안되는 이유 - 모든 경우의 수를 계산해야함



dp일반항
각날마다 사거나 팔거나 홀드하거나..
각날마다 그 상태를 업데이트

 */