class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();

        int max = 0;
        for(int i = 0; i < candies.length; i++){
            if(candies[i] > max){
                max = candies[i];
            }
        }

        for(int i = 0; i < candies.length; i++){
            if(candies[i] + extraCandies >= max){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        }

        return ans;
    }
}
/**
2 3 5 1 3
배열하면 5 3 3 2 1 extra 3
그렇다면 5-2인 2개 가진 애까지는 다 true
나머지는 false

오케이. 그러면 가장 큰 애 구한 다음에 extra그거 뺀 인덱스 찾아서 거기까지 true
나머지는 false

그런데 return 하는 boolean이 순서가 지켜져야 하므로 그냥 체크하면 되겠네
 */