// LeetCode 238 - Product of Array Except Self
// https://leetcode.com/problems/product-of-array-except-self/
//
// Given an integer array nums, return an array answer such that answer[i] is 
// equal to the product of all the elements of nums except nums[i].
//
// You must write an algorithm that runs in O(n) time and without using the division operation.
//
// Example 1: nums = [1,2,3,4]       -> Output: [24,12,8,6]
// Example 2: nums = [-1,1,0,-3,3]    -> Output: [0,0,9,0,0]
//
// Approach: Two-pass (Prefix & Suffix Products)
// 1. First pass (left to right): compute prefix product for each element.
// 2. Second pass (right to left): multiply with suffix product maintained in a variable.
// Time Complexity:  O(n)
// Space Complexity: O(1) extra space (excluding the output array)

import java.util.Arrays;

class Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Calculate prefix products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate suffix products and combine with prefix products
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }

    // ---------- quick test ----------
    public static void main(String[] args) {
        Product_of_Array_Except_Self sol = new Product_of_Array_Except_Self();
        System.out.println(Arrays.toString(sol.productExceptSelf(new int[]{1, 2, 3, 4})));       // [24, 12, 8, 6]
        System.out.println(Arrays.toString(sol.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));  // [0, 0, 9, 0, 0]
    }
}
