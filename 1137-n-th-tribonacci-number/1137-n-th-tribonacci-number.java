class Solution {
    private int[] bottomup_table; // 배열 선언부

    public int tribonacci(int n) {
        bottomup_table = new int[n + 1]; // 배열 초기화
        return calc(n); // 계산부 호출
    }

    public int calc(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        bottomup_table[0] = 0;
        bottomup_table[1] = 1;
        bottomup_table[2] = 1;

        for (int i = 3; i <= n; i++) {
            bottomup_table[i] = bottomup_table[i - 3] + bottomup_table[i - 2] + bottomup_table[i - 1];
        }

        return bottomup_table[n];
    }
}
