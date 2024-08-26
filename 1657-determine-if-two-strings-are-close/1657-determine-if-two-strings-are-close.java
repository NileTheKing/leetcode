class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        boolean[] exists1 = new boolean[26];
        boolean[] exists2 = new boolean[26];

        // 빈도수 및 존재 여부 체크
        for (int i = 0; i < word1.length(); i++) {
            freq1[word1.charAt(i) - 'a']++;
            freq2[word2.charAt(i) - 'a']++;
            exists1[word1.charAt(i) - 'a'] = true;
            exists2[word2.charAt(i) - 'a'] = true;
        }

        // 문자 집합 비교
        for (int i = 0; i < 26; i++) {
            // 문자의 존재 여부가 다르면 false
            if (exists1[i] != exists2[i]) {
                return false;
            }
        }

        // 빈도 수 비교를 위한 정수 배열
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int uniqueCount1 = 0;
        int uniqueCount2 = 0;

        // 빈도 수 배열을 카운트
        for (int i = 0; i < 26; i++) {
            if (freq1[i] > 0) {
                count1[uniqueCount1++] = freq1[i];
            }
            if (freq2[i] > 0) {
                count2[uniqueCount2++] = freq2[i];
            }
        }

        // 정렬된 빈도 수 비교
        Arrays.sort(count1, 0, uniqueCount1);
        Arrays.sort(count2, 0, uniqueCount2);

        for (int i = 0; i < uniqueCount1; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }

        return true;
    }
}
