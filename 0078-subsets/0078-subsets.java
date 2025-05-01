class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, new ArrayList<>(), 0);

        return ans;
    }
    public void dfs(int[] nums, List<Integer> cur, int idx) {
    
        ans.add(new ArrayList<>(cur));
        for (int i = idx; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(nums, cur, i+1);
            cur.remove(cur.size() - 1);
        }
    }
}