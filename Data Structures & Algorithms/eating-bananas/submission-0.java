class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for(int pile:piles){
            maxPile = Math.max(maxPile,pile);
        }

        int left =1;
        int right = maxPile;

        while (left<right){
            int speed = left+(right-left)/2;
            int totalHours = 0;
            for (int pile:piles){
                totalHours += (pile+speed-1)/speed;
            }
            if(totalHours<=h){
                right = speed;
            }else {
                left = speed+1;
            }
        }
        return left;
    }
}
