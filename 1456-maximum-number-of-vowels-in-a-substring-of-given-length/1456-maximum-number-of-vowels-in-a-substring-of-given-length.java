class Solution {
   public boolean containsVowel(String s, int index) {
    char ch = s.charAt(index); // index 위치의 문자를 가져옴
    return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'); // 소문자 모음만 체크
}
    public int maxVowels(String s, int k) {
        int count = 0;
        for(int i = 0; i < k; i++){
            if(containsVowel(s, i))
                count++;
        }
        
        int max = count;
        for(int i = 1; i <= s.length() - k; i++){
            if(containsVowel(s, i - 1)){//움직이면서 빠지는 거 확인
                if(containsVowel(s, i + k - 1))//새로 들어온 거 확인
                    continue;//1개빠지고 1개 늘었으므로 아무것도 안함
                else{
                    //1개 빠지고 0개 추가이므로 -1
                    count--;
                }
            }
            else{// 안빠졌는데
                if(containsVowel(s, i + k - 1)) // 0개빠지고 1개늘었으므로 아묵서도 안함
                    count++;
                else{
                    //0개빠지고 0개 들어왔으므로 -1
                    continue;
                }
            }
            if(count > max)
                max = count;
        }

        return max;
        
    }
}
