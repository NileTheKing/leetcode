class Solution {
    public int minFlips(int a, int b, int c) {
        int cnt = 0;
        int bitLength = Math.max(
            Math.max(Integer.toBinaryString(a).length(), Integer.toBinaryString(b).length()), 
            Integer.toBinaryString(c).length()
        );

        for (int i = 0; i < bitLength; i++) {
            //checking the right most bit if it's 1
            int aBit = a & 1;
            int bBit = b & 1;
            int cBit = c & 1;

            if(cBit == 1){//c의 마지막 비트(비교하는)가 1이면
            //a와 b가 0이면 하나만 바꾸면 됨 
                if(aBit == 0 && bBit == 0){
                    cnt++;
                }
                //else {
                //    continue;
                //}
                
            }
            else {//c의 마지막 비트가 0이라면
                if(aBit == 1 || bBit == 1) {
                    if(aBit == 1 && bBit == 1){
                        cnt += 2;
                    }
                    else {
                        cnt++;
                    }
                }
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;

        }


        return cnt;
    }
}
/**
1000
0011
----
0101  0+1+1+1


 */