class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        int left = 0;
        int right = costs.length - 1;
        long cost = 0;

        while (k-- > 0) {
            while(pq1.size() < candidates && left <= right) {
                pq1.offer(costs[left++]);
            }
            while(pq2.size() < candidates && left <= right) {
                pq2.offer(costs[right--]);
            }
            int a = pq1.size() > 0 ? pq1.peek() : Integer.MAX_VALUE;
            int b = pq2.size() > 0 ? pq2.peek() : Integer.MAX_VALUE;

            if(a <= b) {
                cost += a;
                pq1.poll();
            }
            else {
                cost += b;
                pq2.poll();
            }
        }

        return cost;

        
    }

}