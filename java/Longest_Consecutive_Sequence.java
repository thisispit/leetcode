import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode #128 - Longest Consecutive Sequence
 * Difficulty: Medium
 *
 * Problem:
 * Given an unsorted array of integers nums, return the length of the longest
 * consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 * Example 1:
 *   Input:  nums = [100,4,200,1,3,2]
 *   Output: 4
 *   Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 *   Therefore its length is 4.
 *
 * Example 2:
 *   Input:  nums = [0,3,7,2,5,8,4,6,0,1]
 *   Output: 9
 *
 * Approach: HashSet (Sequence Start Lookup)
 * - Insert all numbers into a HashSet for O(1) average-time lookups and deduplication.
 * - Iterate through each number in the set.
 * - A number is the start of a consecutive sequence only if (num - 1) is NOT
 *   in the set. This ensures each sequence is traversed only once.
 * - From each sequence start, check if (num + 1), (num + 2), ... exist in the
 *   set and count the length of the sequence.
 * - Keep track of and return the maximum sequence length found.
 *
 * Time Complexity : O(n)  each number is visited at most twice (once in loop, once in sequence traversal)
 * Space Complexity: O(n)  to store elements in the HashSet
 */
public class Longest_Consecutive_Sequence {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            // Only start counting if 'num' is the beginning of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    // ── Quick smoke test ──────────────────────────────────────────────────────
    public static void main(String[] args) {
        Longest_Consecutive_Sequence solution = new Longest_Consecutive_Sequence();

        System.out.println("Test 1: " + solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));          // Expected: 4
        System.out.println("Test 2: " + solution.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1})); // Expected: 9
        System.out.println("Test 3: " + solution.longestConsecutive(new int[]{}));                               // Expected: 0
        System.out.println("Test 4: " + solution.longestConsecutive(new int[]{9}));                              // Expected: 1
        System.out.println("Test 5: " + solution.longestConsecutive(new int[]{1, 2, 0, 1}));                    // Expected: 3
    }
}
