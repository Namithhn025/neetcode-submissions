class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int i : piles) {
            right = Math.max(right, i);
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;

         long hours = 0;
            for (int i : piles) {
                hours += (i + mid - 1) / mid;
            }
            if (hours <= h) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }
}