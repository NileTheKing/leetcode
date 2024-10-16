class Solution {
    public int equalPairs(int[][] grid) {
        HashSet<StringBuilder> map1 = new HashSet<>();
        HashSet<StringBuilder> map2 = new HashSet<>();

        for(int i = 0; i < grid.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < grid[0].length; j++){
                sb.append(Integer.toString(grid[i][j]));
                sb.append(" ");
            }
            map1.add(sb);
        }

        for(int i = 0; i < grid.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < grid[0].length; j++){
                sb.append(Integer.toString(grid[j][i]));
                sb.append(" ");
            }
            map2.add(sb);
        }

        int cnt = 0;
        for(StringBuilder sb1 : map1){
            for(StringBuilder sb2 : map2){
                if(sb1.toString().equals(sb2.toString())){
                    cnt++;
                }
            }
        }

        return cnt;
    }
}

/**
점을 순회하면서 거기의 행과 거기의 열이 일치하면 그거 세고 갯수 리턴.
그렇다면 해시는 [3122][1445][2422][2422]이렇게 구성이 되어야한다.그렇다면 생각나는 방법은
스트링빌더로 인트를 스트링응로 바꾼다음에 추가를 해가
그리고 완성된거를 넣어. 그리고 비교.
같다면 카운트 굳

11,1
1,11

이라면 해시1은 11,1 / 1,11이고
      해시2는 11,1/ 1,11이다.
    답은 2여야 하는데 4가 나온다.
    아 11때문에..
 */