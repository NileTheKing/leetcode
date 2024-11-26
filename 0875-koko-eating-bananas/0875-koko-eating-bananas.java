class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int end = Integer.MIN_VALUE; //MAX
        int start = 1; //MIN
        int mid = 0;
        int ans = end;
        for(int i = 0; i < n; i++) {
            if(piles[i] >= end) {//max
                end = piles[i];
            }
            //if(piles[i] <= start) {//min
             //   start = piles[i];
            //}
        }

        while(start <= end) {
            mid = start + (end - start) / 2;
        
            if(isPossible(mid, h, piles)){ //충분했으니까 더 줄여봄
                end = mid - 1;
                ans = mid;

            }
            else{//시간 부족했으니까 더 늘려봄
                start = mid + 1;
            }
        }

        return ans;


    }
    boolean isPossible(int mid, int h, int[] piles) {
        
        //시간당 mid만큼 제거 후 다먹으면 이동. 다먹고나면 무조건 기다려야함.
        int count = 0;
        for(int pile : piles) {
            if(pile % mid != 0){ //몫이 0이 아니면(딱 나눠떨어지는 것이 아니면) 예를들어 5개바나나고 4개먹을수있담녀 2시간걸림.
                count += (pile+ mid - 1) / mid;
            }
            else{
                count = count + pile / mid;
            }
        }
        System.out.println("mid:" + mid + " count:" + count + " time h" + h);
        return count <= h && count > 0 ? true : false;
    }

}
/**
너무 커도 안됨
너무작아도 안됨
사이값을 잘 구해야함
3 11/7ok
3 7/ 5ok
3 4/3no
4ok. end
 */