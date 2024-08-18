class Solution {
    public String reverseWords(String s) {
        String str = s.trim();
         String[] empty = str.split("\\s+");
        StringBuilder answer = new StringBuilder();

        for(int i = empty.length- 1; i >= 0; i--){
            answer.append(empty[i]);
            answer.append(' ');
        }
        
        return answer.toString().trim();
    }
}