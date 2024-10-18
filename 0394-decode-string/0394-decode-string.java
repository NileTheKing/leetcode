class Solution {
    public String decodeString(String s) {

        Stack<Integer> number = new Stack<>();
        Stack<StringBuilder> result = new Stack();
        int n = 0;
        StringBuilder current = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                n = n * 10 + c - '0';
            }

            else {
                if(c == '[') {
                    number.push(n);
                    result.push(current);
                    current = new StringBuilder();
                    n = 0;
                    
                }

                else if (c == ']') {
                    int count = number.pop();

                    StringBuilder sb = result.pop();
                    for(int i = 0; i < count; i++){
                        sb.append(current);
                    }
                    //result.push(sb);
                    current = sb;
                    


                }

                else {
                    current.append(c);
                }
            }
        }

        return current.toString();
    }
}