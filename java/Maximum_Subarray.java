// LeetCode 53 - Maximum Subarray
// https://leetcode.com/problems/maximum-subarray/
//
// Given an integer array nums, find the subarray with the largest sum
// and return its sum.
//
// Example 1: nums = [-2,1,-3,4,-1,2,1,-5,4]  -> Output: 6  ([4,-1,2,1])
// Example 2: nums = [1]                        -> Output: 1
// Example 3: nums = [5,4,-1,7,8]              -> Output: 23
//
// Approach: Kadane's Algorithm
// Time Complexity:  O(n)
// Space Complexity: O(1)

class Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum     = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Either extend the existing subarray or start a new one
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum     = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    // ---------- quick test ----------
    public static void main(String[] args) {
        Maximum_Subarray sol = new Maximum_Subarray();
        System.out.println(sol.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
        System.out.println(sol.maxSubArray(new int[]{1}));                              // 1
        System.out.println(sol.maxSubArray(new int[]{5, 4, -1, 7, 8}));                // 23
        System.out.println(sol.maxSubArray(new int[]{-1, -2, -3}));                    // -1
    }
}
