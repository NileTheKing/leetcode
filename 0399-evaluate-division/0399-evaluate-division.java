class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        HashMap<String, HashMap<String, Double>> gr = buildGraph(equations, values);
        double[] finalAnswer = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++) {
            String dividend  = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);

            if(!gr.containsKey(dividend) || !gr.containsKey(divisor)){
                finalAnswer[i] = -1.0;
            }
            else {
                HashSet<String> vis = new HashSet<>();
                double[] ans = {-1.0};
                double temp = 1.0;
                dfs(dividend, divisor, gr, vis, ans, temp);
                finalAnswer[i] = ans[0];
            }
        }

        return finalAnswer;
        
    }


    //그래프 구현 implenenting a graph
    public HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>>equations,
    double values[]) {

        HashMap<String, HashMap<String, Double>> gr = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double value = values[i];

            gr.putIfAbsent(dividend, new HashMap<>());
            gr.putIfAbsent(divisor, new HashMap<>());

            gr.get(dividend).put(divisor, value);
            gr.get(divisor).put(dividend, 1.0/value);
        }

        return gr;
    }

    public void dfs(String node, String dest, HashMap<String, HashMap<String, Double>> gr, HashSet<String> vis, double[] ans, double temp) {
        //visit checks
        if(vis.contains(node))
            return;
        vis.add(node);

        if(node.equals(dest)) {
            ans[0] = temp;
            return;
        }

        for(Map.Entry<String, Double> entry : gr.get(node).entrySet()) {
            String next = entry.getKey();
            double val = entry.getValue();
            dfs(next, dest, gr,vis, ans, temp * val);
        }
    }
}

/**
지금 문제: 문제에서 주어진 정보를 어떻게 그래프로 구현할 것이냐?
지금 그래프를 어떻게 구현하는지 감은 있지만 자세히는 모름. 그러면 하나씩 해보자.
지금 문제: 정점의 개수를 모름. 그러면 이거를 해시를 이용하여 구현하면 되겠네.
왜 리스트 안쓰고 해시? 원래 그래프 구현은 리스트로 하지만 이거는 노드가 문자열이라는 값을 가져야함





방정식을 푸는 것. 여러 경우의수가 있을 거고 조건을 겹치면 각 값을 유도할 수 있을것.
abc를 각각 구함 ->안됨

각각 상대값을 알 수 있음. 미지수가 3개고 값은 2개니까... 그러면 상대값을 구한 다음에 풀면 되겠네.
그러면 조건식가지고 상대값을 만들고 계산하면 되겠군.

아하 이 상대값을 그래프를 통하면 연결관계와 비율값을 알 수 있겠네

 */