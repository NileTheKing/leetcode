/*class Solution {


    public List<String> letterCombinations(String digits) {
        
        List<String> answer = new ArrayList<>();
        if (digits.isEmpty()) return answer;

        int size = digits.length();
        List<String> mapping  = new ArrayList<>();
        
        //index no
        mapping.add("");//0 1
        mapping.add("");// 1 2
        mapping.add("abc");
        mapping.add("def");
        mapping.add("ghi");
        mapping.add("jkl");
        mapping.add("mno");
        mapping.add("pqrs");
        mapping.add("tuv");
        mapping.add("wxyz");

        int[] arr = new int[size]; // 몇번 번호판 알아야하는지 파악
        for(int i = 0; i < size; i++){
            arr[i] = digits.charAt(i) - '0';
        }

        //이제 문자 어느 번호 문자를 조합하면 될지 아니까 접근하면 됨
        //반복문은 어디까지 할지 모르니까 재귀적으로 dfs백트래킹
        int index = 0;
        backtracking(answer, mapping, new StringBuilder(), arr, index);

        
        return answer;
        


    }

    static void backtracking(List<String> answer, List<String> mapping, StringBuilder current, int[] arr,int index){
        
        if(index == arr.length){//끝에 닿았으면 answer에 넣고 리턴 후 백트래킹
            answer.add(current.toString());
            return;
        }

        int size = mapping.get(arr[index]).length();
        for(int j = 0; j < size; j++){
            current.append(mapping.get(arr[index]).charAt(j));
            backtracking(answer, mapping, current, arr, index + 1);
            current.setLength(current.length() - 1);
        }
        
    }
}
*/

class Solution {


    public List<String> letterCombinations(String digits) {
        
        List<String> answer = new ArrayList<>();
        if (digits.isEmpty()) return answer;

        List<String> mapping  = new ArrayList<>();
        
        //index no
        mapping.add("");//0 1
        mapping.add("");// 1 2
        mapping.add("abc");
        mapping.add("def");
        mapping.add("ghi");
        mapping.add("jkl");
        mapping.add("mno");
        mapping.add("pqrs");
        mapping.add("tuv");
        mapping.add("wxyz");

        backtracking(answer, mapping, new StringBuilder(), digits, 0);

        
        return answer;
        


    }

    static void backtracking(List<String> answer, List<String> mapping, StringBuilder current, String digits, int index){
        
        if(index == digits.length()){//끝에 도달했으면 answer에 넣고 리턴 후 백트래킹
            answer.add(current.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String possibleCharacters = mapping.get(digit);
        for(int i = 0; i < possibleCharacters.length(); i++){
            current.append(possibleCharacters.charAt(i));
            backtracking(answer, mapping, current, digits, index + 1);
            current.setLength(current.length() - 1);
        }
        
    }
}