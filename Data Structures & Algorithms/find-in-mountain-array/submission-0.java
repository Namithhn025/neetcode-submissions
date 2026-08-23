/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {

        int peak = findPeak(mountainArr);

        // Search ascending part first
        int result = binarySearchAscending(
            mountainArr, target, 0, peak
        );

        if (result != -1) {
            return result;
        }

        // Search descending part
        return binarySearchDescending(
            mountainArr, target, peak + 1, mountainArr.length() - 1
        );
    }

    private int findPeak(MountainArray arr) {

        int left = 0;
        int right = arr.length() - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr.get(mid) < arr.get(mid + 1)) {
                // Going UP → peak is on the right
                left = mid + 1;
            } else {
                // Going DOWN → peak is at mid or on the left
                right = mid;
            }
        }

        return left;
    }

    private int binarySearchAscending(
        MountainArray arr,
        int target,
        int left,
        int right
    ) {

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int value = arr.get(mid);

            if (value == target) {
                return mid;
            }

            if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    private int binarySearchDescending(
        MountainArray arr,
        int target,
        int left,
        int right
    ) {

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int value = arr.get(mid);

            if (value == target) {
                return mid;
            }

            // Descending array → directions are reversed
            if (value > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}