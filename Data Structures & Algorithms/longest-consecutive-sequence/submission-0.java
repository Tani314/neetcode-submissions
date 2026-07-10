class Solution {
    public int longestConsecutive(int[] nums) {
         int longest = 0;
         Set<Integer> set = new HashSet<>();
         for (int num:nums){
            set.add(num);
         }
         for(int num:set){
            if (!set.contains(num-1)){
                int current = num;
                int currentLength = 1;
                while(set.contains(current+1)){
                    current++;
                    currentLength++;
                }
                longest= Math.max(longest,currentLength);
            }
         }
         return longest;
    }
}
