class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= first) {
                first = nums[i];
            }
            else if(nums[i] <= second) {
                second = nums[i];
            }
            else {
                return true;
            }
        }

        return false;
    }
}

// class Solution {
//     public boolean increasingTriplet(int[] nums) {
        
//         int max = nums[nums.length - 1];
//         int min = nums[0];

//         for(int i = 1; i < nums.length- 1; i++) {
//             min = Math.min(min, nums[i- 1]);
//             max = Math.max(max, nums[nums.length - 1 - i + 1]);

//             if(nums[i] > min && nums[i] < max) {
//                 System.out.println("결과 : " + "min=" + min + ", " + "mid" + nums[i] + "max=" + max);
//                 return true;
//             }
//         }

//         return false;
//     }
// }
/**
6 7 1 2
min ----
max ++++


 */
// class Solution {
//     public boolean increasingTriplet(int[] nums) {
//         return dfs(new ArrayList<Integer>() , nums, 0);
//     }

//     public boolean dfs(ArrayList<Integer> ints, int[] nums, int idx) { //idx는 해당인덱스 부터 넣어보기 가능하다는 뜻
//         if(ints.size() == 3) {
//             return true;
//         }
        
//         if(ints.size() == 0) {
//             for(int i = 0; i < nums.length; i++) {
//                 ints.add(nums[i]);
//                 if(dfs(ints, nums, i+1)) {
//                     return true;
//                 }
//                 ints.remove(ints.size() -1);
//             }
//         }
//         else{
//             for(int i = idx; i < nums.length; i++) {
//                 if(nums[i] > ints.get(ints.size() - 1)) {//새로운 원소는 전거보다 커야만 들어갈 수 있음. 작으면 패스
//                     ints.add(nums[i]);
//                     if(dfs(ints, nums, i + 1)) {
//                         return true;
//                     }
//                     ints.remove(ints.size() -1);
//                 }
//             }
//         }

//         return false;
//     }
// }
// /**
// 어떠한 3개를 뽑는데 순서대로 뽑는 경우의 수가 있으면 true 아니면 false

// brute-force
// 재귀적으로?백트래킹?
// dfs를 하면 ... 백트래킹은 모든 조합 실제로 구하는 것이냐 카운팅이냐..
// 2 1 5 0 4 6이 있다면 모든 경우의 수를 해봐야겟지
//  */