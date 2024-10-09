class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int first = 0;
        int last = nums.length - 1;//2pointers
        int count = 0;

        while(first < last){
            int added = nums[first] + nums[last];
            if(added < k){
                first++;
            }
            if(added > k){
                last--;
            }
            if(added == k){
                count++;
                first++;
                last--;
            }
        }

        return count;
    }
}
//1 3 3 3 4
//1
//1+4가 6보다 작은데 작으니까 이제 3+4함. 3+4는 크니까 
// 3+3됨. first 1 last 3