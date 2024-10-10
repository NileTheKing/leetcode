class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();

        if(chars.length == 1){
            return chars.length;
        }
        int  count = 1;
        for(int i = 0; i < chars.length - 1; i++){
            if(chars[i] == chars[i+1]){//다음 문자가 현재 문자와 같다면
                count++;
            }

            else{ //다르다면 처리하고 넘어감
                sb.append(chars[i]);
                if(count >= 2){
                    sb.append(count);
                }
                count = 1;
            }
        }

        //마지막 문자에 대한 처리만 하고 넘어감: 1.이전 문자와 동일 ->이전문자랑 카운터 2.다름-> 마지막문자 하나만 딱
        if(chars[chars.length - 1] == chars[chars.length - 2]){
            sb.append(chars[chars.length - 1]);
            sb.append(Integer.toString(count));
        } else {
            sb.append(chars[chars.length - 1]);
        }

        for(int i = 0; i < sb.length(); i++){
            chars[i] = sb.charAt(i);
        }
        System.out.println("chars = " + sb.toString());
        return sb.length();
    }
}