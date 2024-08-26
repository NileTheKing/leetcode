class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length())
            return false;

        int[] listA = new int[26];
        int[] listB = new int[26];

        
        for(int i = 0; i < word1.length(); i++){ //빈도수
            listA[word1.charAt(i) - 'a']++;
            listB[word2.charAt(i) - 'a']++;
        }


        //비교

        for(int i = 0; i < listA.length; i++){
            if((listA[i] > 0 && listB[i] == 0) || (listA[i] == 0 && listB[i] > 0)){
                return false;
            }
        }

        //빈도수 비교
        Map<Integer, Integer> countMap1 = new HashMap<>();
        Map<Integer, Integer> countMap2 = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            if (listA[i] > 0) {
                countMap1.put(listA[i], countMap1.getOrDefault(listA[i], 0) + 1);
            }
            if (listB[i] > 0) {
                countMap2.put(listB[i], countMap2.getOrDefault(listB[i], 0) + 1);
            }
        }

        return countMap1.equals(countMap2);
    }
}
