class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> row = new HashMap<>(); //값과 출현횟수
        Map<String, Integer> col = new HashMap<>();
        int count = 0;

        //row, col 추가
        for(int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid.length; j++){
                sb.append(grid[i][j]).append(",");
            }
            String nums = sb.toString();
            row.put(nums, row.getOrDefault(nums, 0) + 1);
        }

        for(int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid.length; j++){
                sb.append(grid[j][i]).append(",");
            }
            String nums = sb.toString();
            col.put(nums, col.getOrDefault(nums, 0) + 1);
        }

        //비교 및 카운팅
        for(String key : row.keySet()) {
            if(col.containsKey(key)) {
                count = count + row.get(key) * col.get(key);
            }
        }
        return count;
        

    }
}
//열 해시 만들고
//행 해시 만들어서
//열 277을 저장해
//행 277도 저장되어 있으므로 카운트.
/**
Q:해시셋과 해시맵 중 어떤 것을 사용해야 하는가?
해시셋은 값만 해시맵은 키-밸류....
해시끼리 비교를 할거고 같으면 카운트를 할것임.
해시끼리는 값을 비교하겠지 밸류값.
해시맵끼리 비교해야할듯 example2에서 밸류는 같지만 키가 다르니까 중복카운트함.
 */