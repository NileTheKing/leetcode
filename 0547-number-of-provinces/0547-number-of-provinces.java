/*class Solution {
    int cnt = 0;
    public int findCircleNum(int[][] isConnected) {
        int rsize, csize;
        rsize = isConnected.length;
        csize = isConnected[0].length;
        boolean[] visited = new boolean[rsize];
        
        for(int i = 0; i < rsize; i++) {
            searchDfs(i, rsize, visited, isConnected);
        }

        return cnt;
    }
    
    public void searchDfs(int cityIndex, int size, boolean[] visited, int[][] isConnected) {
        if(visited[cityIndex]) return;
        visited[cityIndex] = true;
        for(int i = 0; i < size; i++) { //cityIndex가 진입지점이고 이와 연결된 도시들을 살핌
            //만약 연결된 도시isConnected[cityIndex][i]가 1이고 visited가 false라면
            if(!visited[i] && isConnected[cityIndex][i] == 1) {//방문
                visited[i] = true;//방문 처리
                searchDfs(i, size, visited, isConnected);해당 i를 다시 진입지점으로 하여 재귀호출
                return;//재귀호출을 끝나고 나면  여기서 리턴. ㅋ
            }
            else{

            }
        }
        cnt++;//카운트는 말단에서 더이상 엔트리할 것이 없을 때 카운트.
    }
}
/**
dfs써서 찾는다. 연결되어 있는 방이 있으면 확인한다.
dfs에서 탐색이 종료되면(예를들어 1도시를 메인함수에서 진입
이후 1과 연결된 것을 확인하려고 isConnected배열의 0번 행을 봄. [110]
거기 중 두번째 방을 넘김(dfs함수에 매개변수가 필요하겠군.)

넘겨 받은 두번째 방으로 또 dfs에 들어간다. 
 1번은 방문완료 2번은 자기자신이므로 첫번째 dfs는 ㄷ끝.
 그러면 메이인함수 for문 두번째 dfs진입. 2번방을 넘겨줌
 이미 방문완료되었으므로 카운팅안함
 마지막으로 3번;

 카운팅은 어떻게 하나? 어떻게 해야 할까요.
 카운트란 무엇인가? 연결된 거 계속 파고들다가 더 없으면 카운트. 그말인 즉슨, 
1진입 1번정보 확인.
2번 진입 2번정보 확인 아 만약 들어갈 곳이 없으면 카운트임.궁금한건
재귀함수를 호출한 함수에서도 해당 함수가 종료 되고 나면 카운트를 늘리지 않을까 함.
 */
 
class Solution {
    int cnt = 0;
    public int findCircleNum(int[][] isConnected) {
        int size = isConnected.length;
        boolean[] visited = new boolean[size];

        for(int i = 0; i < size; i++) {
            dfs(i, visited, isConnected);
        }
        return cnt;
    }

    public void dfs(int city, boolean[] visited, int[][] isConnected) {
        if(visited[city]) return;
        visited[city] = true;
        for(int i = 0; i < isConnected.length; i++) {
            if(!visited[i] && isConnected[city][i] == 1) {
                dfs(i, visited, isConnected);
                return;
            }
        }
        cnt++;
    }
}