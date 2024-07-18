class Solution {
    public String removeStars(String s) {
       Stack<Character> stack = new Stack<>();

       for(int i = 0; i < s.length(); i ++){
        if(s.charAt(i) == '*'){
            stack.pop();
       }
       else{
        stack.push(s.charAt(i));
       }
    }

        StringBuilder str = new StringBuilder();
        for (char a : stack) {
        str.append(a);      
        }
        return str.toString();
}
}
