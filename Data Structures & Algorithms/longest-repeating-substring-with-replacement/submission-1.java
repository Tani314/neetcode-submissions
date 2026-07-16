class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> count = new HashMap();
        int left =0; 
        int maxFrequency = 0;
        int longest = 0 ;
        for(int right=0; right<s.length(); right++){
            char c = s.charAt(right);
            count.put(c,count.getOrDefault(c,0)+1);
            maxFrequency = Math.max(maxFrequency, count.get(c));
            while((right-left+1)-maxFrequency>k){
                char leftChar = s.charAt(left);
                count.put(leftChar, count.get(leftChar)-1);
                left++;
            }
            longest = Math.max(longest,right-left+1);
        }

        return longest;
    }
}
