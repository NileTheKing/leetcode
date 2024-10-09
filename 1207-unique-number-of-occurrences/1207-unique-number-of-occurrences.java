class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean flag = false;
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }//map에는 arr에 있는 숫자를 key로 하고 이들의 occurence를 담고 있음.
        //이제는 이 occurence를 또 해시에 넣어서 이들 중에 occurence가 2이상인지 보면 됨.

        Map<Integer, Integer> dup = new HashMap<>(); 
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            dup.put(entry.getValue(), dup.getOrDefault(entry.getValue(), 0) + 1);
            if(dup.get(entry.getValue()) > 1){
                return false;
            }
        }

        return true;
        
    }
}
