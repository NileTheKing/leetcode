class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && 
            (i == flowerbed.length - 1 || flowerbed[i+1] == 0)) {
                i++;//심었으니까 2칸 늘리면 됨
                n--;
            }
        }

        return n == 0;
    }
}