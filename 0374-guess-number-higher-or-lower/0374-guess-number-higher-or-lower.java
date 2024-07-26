/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
  
        int first = 1;
        int last = n;
  


        while(first <= last){
            //int pick = (first + last)/2;
            int pick =  first + (last - first)/2;
            int result = guess(pick);
            if(result == 0)
                return pick;
            if(result == -1){ // 고른 숫자가 정답보다 작은 경우
                last = pick - 1;
            }
            else if(result ==  1){//고른 숫자가 정답보다 큰 경우
                first = pick + 1;
            }

        }
        return -1;
    }
}



