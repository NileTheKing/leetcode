class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '*') {
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }

        for(char c : stack) {
            sb.append(c)
        }

        return sb.toString();
    }
}