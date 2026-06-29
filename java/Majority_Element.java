/**
 * LeetCode #169 - Majority Element
 *
 * Problem:
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 *
 * Approach: Boyer-Moore Voting Algorithm
 * - Maintain a candidate and a count.
 * - If count is 0, set current element as candidate.
 * - If current element equals candidate, increment count; else decrement.
 * - The candidate at the end is the majority element.
 *
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 */
public class Majority_Element {

    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    // Test the solution
    public static void main(String[] args) {
        Majority_Element sol = new Majority_Element();

        int[] nums1 = {3, 2, 3};
        System.out.println("Test 1: " + sol.majorityElement(nums1)); // Expected: 3

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Test 2: " + sol.majorityElement(nums2)); // Expected: 2

        int[] nums3 = {1};
        System.out.println("Test 3: " + sol.majorityElement(nums3)); // Expected: 1
    }
}
