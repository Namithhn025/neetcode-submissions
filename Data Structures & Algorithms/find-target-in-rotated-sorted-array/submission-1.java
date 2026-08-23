class Solution {
    public int search(int[] nums, int target) {

        int pivot = findPivot(nums);

        if (nums[pivot] == target) {
            return pivot;
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

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int binarySearch(int[] nums, int target, int left, int right) {

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}