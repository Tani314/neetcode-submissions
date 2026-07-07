class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            int[] count = new int[26];
            for(char c: str.toCharArray()){
                count[c -'a']++;
            }
            StringBuilder key = new StringBuilder();
            for(int num:count){
                key.append(num).append('#');
            }
            String signature = key.toString();
            if(!map.containsKey(signature)){
                map.put(signature, new ArrayList<>());
            }
            map.get(signature).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
