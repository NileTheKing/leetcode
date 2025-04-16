class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]); //빈도수 기준 내림차순
        for (int key : map.keySet()) {
            pq.offer(new int[]{key, map.get(key)});
        }

        List<Integer> ans = new ArrayList<>();
        while (k > 0 && !pq.isEmpty()) {
            int[] polled = pq.poll();
            ans.add(polled[0]);
            k--;
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}