import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode #49 - Group Anagrams
 * Difficulty: Medium
 *
 * Problem:
 * Given an array of strings, group the anagrams together. An anagram is a word
 * formed by rearranging the letters of another, using all the original letters
 * exactly once. The order of the groups and the order within a group do not matter.
 *
 * Example 1:
 *   Input:  ["eat","tea","tan","ate","nat","bat"]
 *   Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 *   Input:  [""]
 *   Output: [[""]]
 *
 * Example 3:
 *   Input:  ["a"]
 *   Output: [["a"]]
 *
 * Approach: HashMap keyed by a canonical signature
 * - Two strings are anagrams iff they have the same multiset of characters.
 * - Sorting each string gives a stable, comparable signature (the sorted chars),
 *   so anagrams share the same key. We bucket strings by that key.
 *
 * Time Complexity : O(n * k log k)  where n = number of strings, k = max length
 * Space Complexity: O(n * k)        for the map and the stored strings
 */
public class Group_Anagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> groups = new HashMap<>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(groups.values());
    }

    // ── Quick smoke test ──────────────────────────────────────────────────────
    public static void main(String[] args) {
        Group_Anagrams solution = new Group_Anagrams();

        System.out.println(solution.groupAnagrams(
                new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(solution.groupAnagrams(new String[]{""}));
        System.out.println(solution.groupAnagrams(new String[]{"a"}));
    }
}
