class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;  // 방 0은 이미 방문한 것으로 표시
        Stack<Integer> stack = new Stack<>();
        stack.push(0);  // 첫 번째 방을 스택에 추가
        int count = 1;

        
        while (!stack.isEmpty()) {
            int room = stack.pop();  // 스택에서 방 번호를 꺼냄
            for (int key : rooms.get(room)) {  // 현재 방에서 얻은 모든 키를 반복
                if (!visited[key]) {  // 아직 방문하지 않은 방이면
                    stack.push(key);  // 그 방을 스택에 추가
                    visited[key] = true;  // 그 방을 방문한 것으로 표시
                    count++;
                }
            }
        }

        return count == rooms.size();  // 모든 방을 방문했는지 확인
    }
}

