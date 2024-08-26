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
        Arrays.sort(listA);
        Arrays.sort(listB);

        for (int i = 0; i < 26; ++i) {
            if (listA[i] != listB[i]) {
                return false; 
            }
        }
        return true;

    }
}
