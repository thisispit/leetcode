import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode #347 - Top K Frequent Elements
 * Difficulty: Medium
 *
 * Problem:
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 * Example 1:
 *   Input:  nums = [1,1,1,2,2,3], k = 2
 *   Output: [1,2]
 *
 * Example 2:
 *   Input:  nums = [1], k = 1
 *   Output: [1]
 *
 * Approach: Bucket Sort (Frequency Bucketing)
 * - Count the frequency of each element using a HashMap.
 * - Create a bucket array of size nums.length + 1 where bucket[i] stores
 *   all numbers that appear exactly i times.
 * - Iterate from the highest possible frequency (nums.length) down to 1,
 *   collecting numbers into the result until k elements are found.
 *
 * Time Complexity : O(n)  counting frequencies O(n) + bucket collection O(n)
 * Space Complexity: O(n)  for the frequency map and bucket array
 */
public class Top_K_Frequent_Elements {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        // 1. Build frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // 2. Bucket elements by their frequency
        @SuppressWarnings("unchecked")
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int freq = entry.getValue();
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(entry.getKey());
        }

        // 3. Gather top k frequent elements from highest frequency bucket down
        int[] result = new int[k];
        int index = 0;
        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[index++] = num;
                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }

    // ── Quick smoke test ──────────────────────────────────────────────────────
    public static void main(String[] args) {
        Top_K_Frequent_Elements solution = new Top_K_Frequent_Elements();

        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1}, 1)));
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2)));
    }
}
