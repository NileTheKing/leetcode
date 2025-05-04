class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray(); //정렬해서
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(str);
        }

        // for (String key : map.keySet()) {
        //     for (String str : map.get(key)) {
        //         System.out.println(str);
        //     }
        //     System.out.println("---");
        // }
        
        for (String key : map.keySet()) {
            List<String> list = new ArrayList<>();
            for (String str : map.get(key)) {
                list.add(str);
            }
            ans.add(list);
        }

        return ans;
    }
}