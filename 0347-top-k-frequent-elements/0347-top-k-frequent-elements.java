class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //빈도수대로 내림차순
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int key : map.keySet()) {
            pq.offer(new int[] {key, map.get(key)});
        }


        List<Integer> ans = new ArrayList<>();
        while (0 < k) {
            if (pq.peek() == null) break;
            ans.add(pq.poll()[0]);
            k--;
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}
/**
일단은 빈도를 구해야하고
nlongn으로 최소 몇개 찾아야하니까
정렬없이 하려면 빈도를 넣을때 pq를 이용해야함.

 */