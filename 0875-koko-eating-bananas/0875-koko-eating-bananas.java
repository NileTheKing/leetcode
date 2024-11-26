class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int end = Integer.MIN_VALUE; //MAX
        int start = 1; //MIN
        int mid = 0;
        int ans = end;
       
        for(int pile : piles) {
            if(pile > end){
                end = pile;
            }
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
                count += (pile+ mid - 1) / mid;
                if(count > h){
                    return false;
                }
                
            }
        return count <= h;
        }
        //System.out.println("mid:" + mid + " count:" + count + " time h" + h);

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