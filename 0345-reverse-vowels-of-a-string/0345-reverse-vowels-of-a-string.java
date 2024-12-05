class Solution {
    public String reverseVowels(String s) {
        int start = 0;
        int end = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);//일단 복사에서 나중에 스왑

        while(start < end) {
            
            //둘다 짝일때
            if(isVowel(s.charAt(start)) && isVowel(s.charAt(end))) {
                char tmp = s.charAt(start);
                sb.setCharAt(start, s.charAt(end));
                sb.setCharAt(end, tmp);
                start++;
                end--;
            }
            //start만 모음 -> end만 줄여서 계속
            else if(isVowel(s.charAt(start)) && !isVowel(s.charAt(end))) {
                end--;
            }

            //end만 모음
            else if(!isVowel(s.charAt(start)) && isVowel(s.charAt(end))) {
                start++;
            }

            else {
                start++;
                end--;
            }
            

            //둘다 아님
        }

        return sb.toString();

        
    }
    public boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'||
        c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        else {
            return false;
        }
    }
}

/**
투포인터로 찾아서
둘다 찾아지면(모음) 스왑
아니면 그대로 스트링빌더에 씀
 */