class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int size = flowerbed.length;

        if(size == 1) {

            //크기가 1인데 여러개 심으려면 당연히 불가능
            if(n > 1) return false;

            //크기가 1인데 0개나 1개 심는 경우
            else if(flowerbed[0] == 1){
                return n == 0 ? true : false;
            }
            else return true;
        }

    
        if(flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            n--;
        }
        for (int i = 1; i < size -1; i++) {
            //이전칸과 다음칸이 비어있으면. 또는 
    
            if(flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                flowerbed[i] = 1;
                n--;
            }
            //그게 아니라면 ex)현재 탐색중인 칸은 현재칸이차있거나 전칸이 있거나 둘다 차있거나 다음칸이 차있으면 불가능.함
        }
        if(flowerbed[size-1] == 0 && flowerbed[size-1-1] == 0) {
            n--;
        }

        return n <= 0  ? true : false;
    }
}
/**

 */