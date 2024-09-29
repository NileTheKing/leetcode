class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int sLength = spells.length;
        int pLength = potions.length;
        int[] answer = new int[sLength];

        for(int i = 0; i < sLength; i++){//
            int pLow, pHigh, pMid;
            pLow = 0;
            pHigh = pLength - 1;
            while(pLow <= pHigh){//potions값을 이진탐색. 목적? 같을 떄 까지 찾고 거기서부터 카운트.
                pMid = pLow + (pHigh - pLow)/2;
                long mult = (long)spells[i] * potions[pMid];
                if(mult < success){
                    pLow = pMid + 1;
                }

                else{
                    pHigh = pMid - 1;
                }

            }//종료 된 게 while조건. pLow = pMid = pHigh
 
            answer[i] = pLength - pLow;

        
        }
        return answer;
    }
}

/*


*/