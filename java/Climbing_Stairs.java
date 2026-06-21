// LeetCode 70 - Climbing Stairs
// https://leetcode.com/problems/climbing-stairs/
//
// You are climbing a staircase. It takes n steps to reach the top.
// Each time you can either climb 1 or 2 steps.
// In how many distinct ways can you climb to the top?
//
// Example 1: n = 2  -> Output: 2  (1+1, 2)
// Example 2: n = 3  -> Output: 3  (1+1+1, 1+2, 2+1)

import java.util.HashMap;

class Climbing_Stairs {

    // -------------------------------------------------------
    // Approach 1: Bottom-Up DP (Fibonacci pattern)
    // Time Complexity:  O(n)
    // Space Complexity: O(1)
    // -------------------------------------------------------
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int prev2 = 1; // ways to reach step 1
        int prev1 = 2; // ways to reach step 2

        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    // -------------------------------------------------------
    // Approach 2: Top-Down DP with Memoization (Recursion)
    // Time Complexity:  O(n)
    // Space Complexity: O(n)  — memo map + call stack
    // -------------------------------------------------------
    private HashMap<Integer, Integer> memo = new HashMap<>();

    public int climbStairsMemo(int n) {
        if (n <= 2) return n;
        if (memo.containsKey(n)) return memo.get(n);

        int result = climbStairsMemo(n - 1) + climbStairsMemo(n - 2);
        memo.put(n, result);
        return result;
    }

    // ---------- quick test ----------
    public static void main(String[] args) {
        Climbing_Stairs sol = new Climbing_Stairs();

        System.out.println("--- Bottom-Up DP ---");
        System.out.println(sol.climbStairs(2));  // 2
        System.out.println(sol.climbStairs(3));  // 3
        System.out.println(sol.climbStairs(5));  // 8
        System.out.println(sol.climbStairs(10)); // 89

        System.out.println("--- Top-Down Memoization ---");
        System.out.println(sol.climbStairsMemo(2));  // 2
        System.out.println(sol.climbStairsMemo(3));  // 3
        System.out.println(sol.climbStairsMemo(5));  // 8
        System.out.println(sol.climbStairsMemo(10)); // 89
    }
}
