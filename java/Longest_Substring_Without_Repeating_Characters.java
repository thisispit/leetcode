/**
 * LeetCode #3 - Longest Substring Without Repeating Characters
 *
 * Problem:
 *   Given a string s, find the length of the longest substring
 *   without repeating characters.
 *
 * Approach: Sliding Window + HashMap
 *   - Use two pointers (left, right) to maintain a window.
 *   - Expand right pointer; if a duplicate is found, shrink from left.
 *   - Track the last seen index of each character in a HashMap.
 *
 * Time Complexity:  O(n) — each character is visited at most twice
 * Space Complexity: O(min(n, m)) — m = charset size (e.g., 128 for ASCII)
 *
 * Examples:
 *   Input: "abcabcbb" → Output: 3  ("abc")
 *   Input: "bbbbb"    → Output: 1  ("b")
 *   Input: "pwwkew"   → Output: 3  ("wke")
 */

import java.util.HashMap;

public class Longest_Substring_Without_Repeating_Characters {

    public int lengthOfLongestSubstring(String s) {
        // Map character → last seen index
        HashMap<Character, Integer> lastSeen = new HashMap<>();
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // If character was seen and is inside current window, move left pointer
            if (lastSeen.containsKey(ch) && lastSeen.get(ch) >= left) {
                left = lastSeen.get(ch) + 1;
            }

            lastSeen.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // ── Driver / Test ────────────────────────────────────────────────────────
    public static void main(String[] args) {
        Longest_Substring_Without_Repeating_Characters sol =
                new Longest_Substring_Without_Repeating_Characters();

        String[] testCases = {"abcabcbb", "bbbbb", "pwwkew", "", " ", "au", "dvdf"};
        int[]    expected   = {3, 1, 3, 0, 1, 2, 3};

        System.out.println("Longest Substring Without Repeating Characters");
        System.out.println("==============================================");

        for (int i = 0; i < testCases.length; i++) {
            int result = sol.lengthOfLongestSubstring(testCases[i]);
            String status = (result == expected[i]) ? "✓ PASS" : "✗ FAIL";
            System.out.printf("%s | Input: %-12s | Expected: %d | Got: %d%n",
                    status, "\"" + testCases[i] + "\"", expected[i], result);
        }
    }
}
