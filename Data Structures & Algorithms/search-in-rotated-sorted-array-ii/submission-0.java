class Solution {
    public boolean search(int[] nums, int target) {

        int pivot = findPivot(nums);

        if (pivot == -1) {
            return false;
        }

        if (nums[pivot] == target) {
            return true;
        }

        // No rotation
        if (pivot == 0) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        // Left sorted portion
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }

        // Right sorted portion
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    private int findPivot(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // Case 1: mid itself is the pivot
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }

            // Case 2: element before mid is the pivot
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid;
            }

            // Duplicates
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {

                // Check if start is pivot
                if (start < end && nums[start] > nums[start + 1]) {
                    return start + 1;
                }

                start++;

                // Check if end is pivot
                if (end > start && nums[end] < nums[end - 1]) {
                    return end;
                }

                end--;
            }

            // Left side is sorted
            else if (nums[start] < nums[mid]
                    || (nums[start] == nums[mid] && nums[mid] > nums[end])) {

                start = mid + 1;
            }

            // Pivot is on left
            else {
                end = mid - 1;
            }
        }

        // Array is not rotated
        return 0;
    }

    private boolean binarySearch(int[] nums, int target, int left, int right) {

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}