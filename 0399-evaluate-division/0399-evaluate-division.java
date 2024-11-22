class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> gr = new HashMap<>();//그래프 구현
        double[] ans = new double[queries.size()];
        int ansIdx = 0;
        gr = buildGraph(equations, values);
        for(List<String> query : queries) {
            String departure = query.get(0);
            String destination = query.get(1);

            if(!gr.containsKey(departure) && !gr.containsKey(destination)){
                ans[ansIdx++] = -1.0;
            }
            else{
            HashSet<String> visited = new HashSet<>();
            ans[ansIdx++] = dfs(gr, departure, destination, 1.0, visited);
            }

        }
        return ans;

    }

    //그래프 구현
    public HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        HashMap<String, HashMap<String, Double>> gr = new HashMap<>();
        int idx = 0; //index to keep track of values
        for(var equation : equations) {// list= a,b
            String departure = equation.get(0);//a
            String destination = equation.get(1);//b
            double weight = values[idx++];// a/b = 2

            //정점 추가
            gr.putIfAbsent(departure, new HashMap<>());
            gr.putIfAbsent(destination, new HashMap<>());

            //간선 추가
            gr.get(departure).put(destination, weight);
            gr.get(destination).put(departure, 1.0/weight);
        }
        

        //그래프 완성했으므로 리턴
        return gr;
    }

    //이제 그래프 구현은 다 했으므로 답구하는 dfs알고리즘 ㄱㄱ
    public double dfs(HashMap<String, HashMap<String, Double>> gr, String current, String destination,
        double temp, HashSet<String> visited) {
        
        if (!gr.containsKey(current)) { // current 노드가 그래프에 없을 경우
        return -1.0;
        }

        if(visited.contains(current)){
            return -1.0;
        }
        visited.add(current);
        if(current.equals(destination)) {
            return temp;
        }

        //현재 노드에서 연결된 모든 노드를 순회(시도) 해야함.
        for(Map.Entry<String, Double> entry : gr.get(current).entrySet()) {
            String next = entry.getKey();
            double val = entry.getValue();
            double result = dfs(gr, next, destination, temp * val, visited);
            if(result != -1.0){
                return result;
            }
        }

        return -1.0;

        
    }
    
}
/**
-dfs를 호출하는 부분이 메인함수에 위치,, numbers of provinces 문제와 유사함. 또 혼동
-Q: double[] ans 이거 어디에 위치 시켜야함? -> 마음대로 하면 될듯. dfs의 리턴값을 double로 받아서 메인함수측에서 답 추가하면 됨
 */