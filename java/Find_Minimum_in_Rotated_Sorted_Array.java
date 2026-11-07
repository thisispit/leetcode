/**
 * LeetCode #153 - Find Minimum in Rotated Sorted Array
 * Difficulty: Medium
 *
 * Problem:
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
 * For example, the array nums = [0,1,2,4,5,6,7] might become:
 *   [4,5,6,7,0,1,2] if it was rotated 4 times.
 *   [0,1,2,4,5,6,7] if it was rotated 7 times.
 *
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array
 * [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 *
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 *
 * You must write an algorithm that runs in O(log n) time.
 *
 * Example 1:
 *   Input:  nums = [3,4,5,1,2]
 *   Output: 1
 *   Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 *
 * Example 2:
 *   Input:  nums = [4,5,6,7,0,1,2]
 *   Output: 0
 *   Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
 *
 * Example 3:
 *   Input:  nums = [11,13,15,17]
 *   Output: 11
 *   Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
 *
 * Approach: Binary Search
 * - Compare nums[mid] with nums[right].
 * - If nums[mid] > nums[right]:
 *     The inflection point (minimum) must be in the right half strictly after mid,
 *     so we set left = mid + 1.
 * - Else (nums[mid] <= nums[right]):
 *     The minimum is at mid or in the left half, so we set right = mid.
 * - When left == right, nums[left] is the minimum element.
 *
 * Time Complexity : O(log n)  halves the search space on each iteration
 * Space Complexity: O(1)      constant extra space
 */
public class Find_Minimum_in_Rotated_Sorted_Array {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array must not be null or empty.");
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum must be strictly in the right half
                left = mid + 1;
            } else {
                // Minimum is at mid or in the left half
                right = mid;
            }
        }

        return nums[left];
    }

    // ── Quick smoke test ──────────────────────────────────────────────────────
    public static void main(String[] args) {
        Find_Minimum_in_Rotated_Sorted_Array solution = new Find_Minimum_in_Rotated_Sorted_Array();

        System.out.println("Test 1: " + solution.findMin(new int[]{3, 4, 5, 1, 2}));          // Expected: 1
        System.out.println("Test 2: " + solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));    // Expected: 0
        System.out.println("Test 3: " + solution.findMin(new int[]{11, 13, 15, 17}));         // Expected: 11
        System.out.println("Test 4: " + solution.findMin(new int[]{1}));                      // Expected: 1
        System.out.println("Test 5: " + solution.findMin(new int[]{2, 1}));                   // Expected: 1
        System.out.println("Test 6: " + solution.findMin(new int[]{3, 1, 2}));                // Expected: 1
    }
}
