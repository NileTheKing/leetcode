class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 0) return 0;
        if (n == 1) return cost[0];
        
        int first = cost[0]; //불필요한 bottomup table 대신 두개만 저장하면 되므로 변수 두개 선언
        int second = cost[1];
        
        for (int i = 2; i < n; i++) {
            int current = Math.min(first, second) + cost[i];
            first = second;
            second = current;
        }
        
        return Math.min(first, second);
    }
}
