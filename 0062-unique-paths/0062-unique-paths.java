class Solution {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        
        for(int i = 0; i < m; i++)
            paths[i][0] = 1;
        for(int j = 0; j < n; j++)
            paths[0][j] = 1;
        
        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j++)
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
        }
        
        return paths[m-1][n-1];
    }
}
//기존 답을 계속 이용하며 합함. 수학시간에 해본 거 ㅇㅇ
//dp bottom-up(top-down도 도나?)를 이용해서 저장하며 하면 됨ㅇㅇ
