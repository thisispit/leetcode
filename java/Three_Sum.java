import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode #15 - 3Sum
 * Difficulty: Medium
 *
 * Problem:
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * The solution set must not contain duplicate triplets.
 *
 * Example 1:
 *   Input:  [-1,0,1,2,-1,-4]
 *   Output: [[-1,-1,2],[-1,0,1]]
 *
 * Example 2:
 *   Input:  [0,1,1]
 *   Output: []
 *
 * Example 3:
 *   Input:  [0,0,0]
 *   Output: [[0,0,0]]
 *
 * Approach: Sort + two pointers
 * - Sort the array so duplicates are adjacent and order is predictable.
 * - Fix the first element nums[i], then use a left/right pointer pair to find
 *   two numbers that sum to -nums[i].
 * - Skip duplicate values at every level to avoid duplicate triplets in the result.
 *
 * Time Complexity : O(n^2)  sorting O(n log n) + O(n) two-pointer scan per element
 * Space Complexity: O(1)    excluding the output list
 */
public class Three_Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    // ── Quick smoke test ──────────────────────────────────────────────────────
    public static void main(String[] args) {
        Three_Sum solution = new Three_Sum();

        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution.threeSum(new int[]{0, 1, 1}));
        System.out.println(solution.threeSum(new int[]{0, 0, 0}));
    }
}
