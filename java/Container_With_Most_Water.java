/**
 * LeetCode #11 - Container With Most Water
 * Difficulty: Medium
 *
 * Problem:
 * You are given an integer array height of length n. There are n vertical lines
 * drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the
 * container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 *
 * Example 1:
 *   Input:  height = [1,8,6,2,5,4,8,3,7]
 *   Output: 49
 *   Explanation: The vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 *   In this case, the max area of water the container can contain is 49.
 *
 * Example 2:
 *   Input:  height = [1,1]
 *   Output: 1
 *
 * Approach: Two Pointers (Greedy)
 * - Start with two pointers at the extreme ends: left at 0 and right at n - 1.
 * - Calculate the area formed between left and right: (right - left) * min(height[left], height[right]).
 * - Update the maxArea found so far.
 * - Move the pointer with the smaller height inward, because moving the taller pointer
 *   inward could only reduce width without the possibility of an increased bounding height.
 * - Repeat until the two pointers meet.
 *
 * Time Complexity : O(n)  single pass with two pointers
 * Space Complexity: O(1)  constant extra space
 */
public class Container_With_Most_Water {

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int currentArea = width * minHeight;

            if (currentArea > maxArea) {
                maxArea = currentArea;
            }

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    // ── Quick smoke test ──────────────────────────────────────────────────────
    public static void main(String[] args) {
        Container_With_Most_Water solution = new Container_With_Most_Water();

        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // Expected: 49
        System.out.println(solution.maxArea(new int[]{1, 1}));                         // Expected: 1
        System.out.println(solution.maxArea(new int[]{4, 3, 2, 1, 4}));                // Expected: 16
        System.out.println(solution.maxArea(new int[]{1, 2, 1}));                      // Expected: 2
    }
}
