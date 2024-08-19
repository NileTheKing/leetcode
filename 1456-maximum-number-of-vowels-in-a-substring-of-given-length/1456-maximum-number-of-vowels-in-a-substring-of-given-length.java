class Solution {
    public boolean containsVowel(String s, int index) {
        char ch = s.charAt(index); // index 위치의 문자를 가져옴
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'); //모음 체크
    }

    public int maxVowels(String s, int k) {
        int max = 0;
        int count = 0;

        // 초기 k 길이의 모음 개수를 계산
        for (int i = 0; i < k; i++) {
            if (containsVowel(s, i)) {
                count++;
            }
        }
        max = count; // 초기 최대값 설정

        // 슬라이딩 윈도우 기법
        for (int i = 1; i <= s.length() - k; i++) {
            // 이전 문자 확인
            if (containsVowel(s, i - 1)) {
                count--; // 이전 문자가 모음이면 카운트 감소
            }
            // 새로 들어온 문자 확인
            if (containsVowel(s, i + k - 1)) {
                count++; // 새로 들어온 문자가 모음이면 카운트 증가
            }
            // 최대 모음 개수 업데이트
            if (count > max) {
                max = count;
            }
        }

        return max;
    }
}
