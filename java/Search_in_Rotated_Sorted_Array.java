/**
 * LeetCode #33 - Search in Rotated Sorted Array
 * Difficulty: Medium
 *
 * Problem:
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown
 * pivot index k (1 <= k < nums.length) such that the resulting array is
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]].
 *
 * Given the array nums after the possible rotation and an integer target, return
 * the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 *   Input:  nums = [4,5,6,7,0,1,2], target = 0
 *   Output: 4
 *
 * Example 2:
 *   Input:  nums = [4,5,6,7,0,1,2], target = 3
 *   Output: -1
 *
 * Example 3:
 *   Input:  nums = [1], target = 0
 *   Output: -1
 *
 * Approach: Modified Binary Search
 * - In a rotated sorted array, at least one half (left or right) is always sorted.
 * - Find mid = left + (right - left) / 2.
 * - If nums[mid] == target, return mid.
 * - If the left half is sorted (nums[left] <= nums[mid]):
 *   - Check if target falls within [nums[left], nums[mid]).
 *   - If yes, eliminate the right half (right = mid - 1).
 *   - Otherwise, search the right half (left = mid + 1).
 * - Else (the right half is sorted):
 *   - Check if target falls within (nums[mid], nums[right]].
 *   - If yes, eliminate the left half (left = mid + 1).
 *   - Otherwise, search the left half (right = mid - 1).
 * - If left > right without finding the target, return -1.
 *
 * Time Complexity : O(log n)  halves search space on each step
 * Space Complexity: O(1)      constant extra space
 */
public class Search_in_Rotated_Sorted_Array {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Determine if the left half is sorted
            if (nums[left] <= nums[mid]) {
                // Target lies in the sorted left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // Right half must be sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    // ── Quick smoke test ──────────────────────────────────────────────────────
    public static void main(String[] args) {
        Search_in_Rotated_Sorted_Array solution = new Search_in_Rotated_Sorted_Array();

        System.out.println("Test 1: " + solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)); // Expected: 4
        System.out.println("Test 2: " + solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)); // Expected: -1
        System.out.println("Test 3: " + solution.search(new int[]{1}, 0));                   // Expected: -1
        System.out.println("Test 4: " + solution.search(new int[]{1}, 1));                   // Expected: 0
        System.out.println("Test 5: " + solution.search(new int[]{5, 1, 3}, 5));             // Expected: 0
        System.out.println("Test 6: " + solution.search(new int[]{5, 1, 3}, 3));             // Expected: 2
    }
}
