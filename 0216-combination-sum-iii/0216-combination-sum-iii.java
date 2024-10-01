class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(answer, new ArrayList<Integer>(), k, n, 1);
        return answer;
    }
    
    static void dfs(List<List<Integer>> answer, ArrayList<Integer> current, int k, int n, int from){
        if(current.size() == k && n == 0){
            answer.add(new ArrayList<>(current));//새로운 객체로 복사하여야 참조에 의한 오류가 일어나지 않는다.
            return;
        }

        for(int i = from; i <= 9; i++){
            current.add(i);
            dfs(answer, current, k, n - i, i + 1);
            current.remove(current.size() - 1);
        }

    }

}
