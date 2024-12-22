class Solution {
    public boolean isSubsequence(String s, String t) {
        int length1 = s.length();
        if(length1 == 1) {
            for(int i = 0; i < t.length(); i++) {
                if(s.charAt(0) == t.charAt(i)) {
                    return true;
                }
            }
        }
        int length2 = t.length();

        int start1 = 0;
        int start2 = 0;

        int end1 = length1 - 1;
        int end2 = length2 - 1;

        while(start1 <= end1 && start2 < end2) {//s순회다하면 루프는 종료해야함
            if(s.charAt(start1) == t.charAt(start2)) {
                start1++;
                start2++;
            }
            else{
                start2++;
            }

            if(s.charAt(end1) == t.charAt(end2)) {
                end1--;
                end2--;
            }
            else {
                end2--;
            }
        }


        return start1 <= end1 ? false : true;
    }
}
/**
s는 t보다 짧음.
투포인터를 이용. 왜냐? 순서가 정렬되어얐어야 함.

종료조건:
s에 있는 거를 다 순회하면 무조건 끝. 왜냐하면 성공해야 옮길 것이기 때문
s에 있는 거를 순회못했으면 끝?노. 이상태에서 t까지 순회끝나면 확실히 끝. 순회 다 못했으면 끝까지 가며 됨.

abbc
ahbdc

bb
hbd

bb
b


 */