public class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder(); // 결과 문자열 저장

        int i = 0, j = 0; // 각 문자열의 인덱스 추적
        int len1 = word1.length(), len2 = word2.length();

        while (i < len1 || j < len2) { //문자열 두개 모두 순회하기 전까지
            if (i < len1) {
                merged.append(word1.charAt(i));
                i++;
            }

            if (j < len2) {
                merged.append(word2.charAt(j));
                j++;
            }
        }

        return merged.toString();
    }
}