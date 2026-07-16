class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        Map<Character,Integer> need = new HashMap();
        Map<Character,Integer> window = new HashMap();
        for(char c:t.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left =0;
        int start=0;
        int have = 0;
        int needCount= need.size();
        int minLength = Integer.MAX_VALUE;

        for(int right = 0; right<s.length(); right++){
            char c = s.charAt(right);
            window.put(c,window.getOrDefault(c,0)+1);
            if(need.containsKey(c)&& window.get(c).intValue()==need.get(c).intValue()){
                have++;
            }
            //The current window contains everything we need.
            //The while loop is trying to find the smallest valid window for the current right pointer.
            while (have==needCount){
                if(right-left+1<minLength){
                    minLength=right-left+1;
                    start=left;
                }
                char leftChar= s.charAt(left);
                window.put(leftChar,window.get(leftChar)-1);
                if(need.containsKey(leftChar)&& window.get(leftChar)<need.get(leftChar)){
                    have--;
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE? "" : s.substring(start,start+minLength);
    }
}
