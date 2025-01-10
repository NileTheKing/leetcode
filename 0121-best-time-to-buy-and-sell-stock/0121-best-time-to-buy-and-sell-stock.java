class Solution {
    public int maxProfit(int[] prices) {
        int cheapest = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            cheapest = Math.min(prices[i], cheapest);

            if (cheapest == prices[i]) {
                continue;
            }
            else {
                maxProfit = Math.max(maxProfit, prices[i] - cheapest);
            }
        }

        return maxProfit;
    }
}