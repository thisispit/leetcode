// LeetCode 283 - Move Zeroes
// Difficulty: Easy
// Approach: Two Pointer (in-place)
// Time Complexity: O(n) | Space Complexity: O(1)
//
// Key Insight: Use a slow pointer to track the position of the next non-zero element.
// Swap non-zero elements to the front while preserving relative order.

class Move_Zeroes {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;

        // Move all non-zero elements to the front
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        // Fill the rest with zeroes
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void main(String[] args) {
        Move_Zeroes sol = new Move_Zeroes();

        // Test Case 1: [0,1,0,3,12] -> [1,3,12,0,0]
        int[] arr1 = {0, 1, 0, 3, 12};
        sol.moveZeroes(arr1);
        System.out.print("Test 1: ");
        for (int x : arr1) System.out.print(x + " "); // Expected: 1 3 12 0 0
        System.out.println();

        // Test Case 2: [0] -> [0]
        int[] arr2 = {0};
        sol.moveZeroes(arr2);
        System.out.print("Test 2: ");
        for (int x : arr2) System.out.print(x + " "); // Expected: 0
        System.out.println();

        // Test Case 3: [1,0,0,2,3] -> [1,2,3,0,0]
        int[] arr3 = {1, 0, 0, 2, 3};
        sol.moveZeroes(arr3);
        System.out.print("Test 3: ");
        for (int x : arr3) System.out.print(x + " "); // Expected: 1 2 3 0 0
        System.out.println();
    }
}
