// LeetCode 70 - Climbing Stairs
// https://leetcode.com/problems/climbing-stairs/
//
// You are climbing a staircase. It takes n steps to reach the top.
// Each time you can either climb 1 or 2 steps.
// In how many distinct ways can you climb to the top?
//
// Example 1: n = 2  -> Output: 2  (1+1, 2)
// Example 2: n = 3  -> Output: 3  (1+1+1, 1+2, 2+1)
//
// Approach: Dynamic Programming (Fibonacci pattern)
// Time Complexity:  O(n)
// Space Complexity: O(1)

class Climbing_Stairs {
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

    // ---------- quick test ----------
    public static void main(String[] args) {
        Climbing_Stairs sol = new Climbing_Stairs();
        System.out.println(sol.climbStairs(2));  // 2
        System.out.println(sol.climbStairs(3));  // 3
        System.out.println(sol.climbStairs(5));  // 8
        System.out.println(sol.climbStairs(10)); // 89
    }
}
