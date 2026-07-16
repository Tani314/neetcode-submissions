class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        for(int right=0; right<nums.length;right++){
            // Remove indices outside the window
            while(!deque.isEmpty()&& deque.peekFirst()<right-k+1){
                deque.pollFirst();
            }
            //Remove smaller values
            while(!deque.isEmpty() && nums[right]>nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(right);
            if(right>=k-1){
                result[index]=nums[deque.peekFirst()];
                index++;
            }
        }
        return result;
    }
}
