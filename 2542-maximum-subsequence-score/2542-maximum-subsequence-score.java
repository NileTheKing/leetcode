class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        
        int length = nums1.length;
        int[][] pairs = new int[length][2];
        for(int i = 0; i < length; i++) {
            pairs[i] = new int[] {nums1[i], nums2[i]};
        }
        Arrays.sort(pairs, (a,b) -> b[1] - a[1]); //내림차순 정렬. nums2 기준
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);//최소힙
        long res = 0, sum = 0;
        for(var pair : pairs) {
            minHeap.add(pair[0]);
            sum = sum + pair[0];
            if(minHeap.size() > k) sum = sum - minHeap.poll(); //최소힙이 초과된다면 제일 작은애는 보냄. 왜냐하면 
            if(minHeap.size() == k) res = Math.max(res, sum * pair[1]);//여기서 굴러들러온 애가 더 낫다는 게 증명되었으므로
            //작은 애는 일말의 가능성조차 없음.
        }
        return res;
        

    }
}
/**
쉽게 생각하면 배열이 두개가 있고 각 배열에는 점수가 담겨있음. 같은 갯수.
그리고 문제에서 주어지는 k만큼의 인덱스를 고를 수 있음. 이것으로 무엇을 하냐하면
고른 k개의 숫자에 해당하는 인덱스의 숫자를 더한 다음
2번 배열에서의 최솟값을 뽑아서 곱함

그 중 가능한 최댓값을 리턴하는 것.
음.....k개의 인덱스를 고르는 방법은 nums.length C k개의 경우의 수가 있음

 */