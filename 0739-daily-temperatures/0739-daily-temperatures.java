class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> mono = new Stack<>();
        int[] ngm = new int[temperatures.length]; //ngm stands for next greatest number

        mono.push(0);
        for(int i = 1; i < temperatures.length; i++){
            int index = i;
            while(!mono.isEmpty() && temperatures[i] > temperatures[mono.peek()]){ //접근 중인 원소의 값이 스택의 탑보다 크면 크기가 맞을 때 까지 다 끄집어내서 넣고 스택에는 자신의 인덱스.
                index = mono.pop();
                ngm[index] = i - index;
            }
            mono.push(i);
        }
           return ngm;
    }


}

/*
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            int count = 0;
            int max = temperatures[i];
            for(int j = i + 1; j < temperatures.length; j++){
                if(temperatures[j] > max){
                    answer[i] = ++count;
                    break;
                }
                else count++;
            }
        }
        return answer;
    }
}
*/