class Solution {
    public String gcdOfStrings(String str1, String str2) {
        StringBuilder sb = new StringBuilder();// prefix
        int idx = 0;

        int minLength = Math.min(str1.length(), str2.length());
        int maxGongyaksu = 0;

        for (int i = 1; i <= minLength; i++) {// 공약수 구하기
            if (str1.length() % i == 0 && str2.length() % i == 0){
                maxGongyaksu = i;
            }
        }
        
        while (idx < maxGongyaksu) { // 공약수까지만 prefix구하기
            if (str1.charAt(idx) == str2.charAt(idx)) {
                sb.append(str1.charAt(idx));// 추가한 다음에 str1과 str2 둘다에 해당하는지 확인하는 작업 필요.
                idx++;
            } else {
                break;
            }
        }

        // 구한 prefix로 테스트하기. 테스트 해보고 안될때마다 하나씩 자르기
        while (sb.length() > 0) {
            StringBuilder a = new StringBuilder(sb);
            StringBuilder b = new StringBuilder(sb);

            for (int i = 1; i < str1.length() / sb.length(); i++) {
                a.append(sb);
            }
            for (int i = 1; i < str2.length() / sb.length(); i++) {
                b.append(sb);
            }

            if (a.toString().equals(str1) && b.toString().equals(str2)) {
                return sb.toString();
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        return "";
    }
}
//let's use Commutative Property next time
