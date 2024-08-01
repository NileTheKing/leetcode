class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minimumCost = new int[cost.length];
        return calc(cost, minimumCost);
        
    }
    
    public int calc(int[] cost, int[] minimumCost){
        minimumCost[0] = cost[0];
        minimumCost[1] = cost[1];
        
        for(int i = 2; i < cost.length; i++){
            minimumCost[i] = Math.min(minimumCost[i-1] + cost[i], minimumCost[i - 2] + cost[i]);
        }
        
        return Math.min(minimumCost[cost.length -2], minimumCost[cost.length -1]);
        
        
    }
}
