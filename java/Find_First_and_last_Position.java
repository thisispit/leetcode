// Find First and Last Position of Element in Sorted Array
// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.

class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{
            binarySearch(nums, target, true),
            binarySearch(nums, target, false)
        };
    }

    public int binarySearch(int[] nums, int target, boolean first) {
        int left = 0, right = nums.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                ans = mid;
                if (first)
                    right = mid - 1;
                else
                    left = mid + 1;
            } 
            else if (nums[mid] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
