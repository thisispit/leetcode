// LeetCode 136 - Single Number
// Difficulty: Easy
// Approach: XOR Bit Manipulation
// Time Complexity: O(n) | Space Complexity: O(1)
//
// Key Insight: XOR of a number with itself is 0, and XOR with 0 is the number itself.
// So XOR-ing all elements cancels out duplicates, leaving the single number.

class Single_Number {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        Single_Number sol = new Single_Number();

        // Test Case 1: [2, 2, 1] -> 1
        System.out.println(sol.singleNumber(new int[]{2, 2, 1}));       // Expected: 1

        // Test Case 2: [4, 1, 2, 1, 2] -> 4
        System.out.println(sol.singleNumber(new int[]{4, 1, 2, 1, 2})); // Expected: 4

        // Test Case 3: [1] -> 1
        System.out.println(sol.singleNumber(new int[]{1}));              // Expected: 1
    }
}
