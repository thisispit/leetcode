/**
 * LeetCode #88 - Merge Sorted Array
 *
 * Problem:
 *   You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 *   and two integers m and n, representing the number of elements in nums1 and nums2
 *   respectively. Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *   The final sorted array should not be returned by the function, but instead be stored
 *   inside the array nums1. To accommodate this, nums1 has a length of m + n, where the
 *   first m elements denote the elements that should be merged, and the last n elements
 *   are set to 0 and should be ignored. nums2 has a length of n.
 *
 * Approach: Two-pointer from the end (in-place, O(m+n) time, O(1) space)
 *   - Start three pointers: p1 at m-1, p2 at n-1, and p at m+n-1.
 *   - Compare elements from the back and place the larger one at position p.
 *   - If nums2 still has elements left after nums1 is exhausted, copy them.
 *
 * Time Complexity : O(m + n)
 * Space Complexity: O(1)
 */
public class Merge_Sorted_Array {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;       // pointer for nums1
        int p2 = n - 1;       // pointer for nums2
        int p  = m + n - 1;   // pointer for merged position in nums1

        // Fill nums1 from the back
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // If nums2 still has remaining elements, copy them
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
        // If nums1 still has remaining elements, they are already in place
    }

    // ── Driver ────────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        Merge_Sorted_Array sol = new Merge_Sorted_Array();

        // Example 1: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        sol.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        System.out.print("Example 1: ");
        printArray(nums1); // Expected: [1,2,2,3,5,6]

        // Example 2: nums1 = [1], m = 1, nums2 = [], n = 0
        int[] nums2 = {1};
        sol.merge(nums2, 1, new int[]{}, 0);
        System.out.print("Example 2: ");
        printArray(nums2); // Expected: [1]

        // Example 3: nums1 = [0], m = 0, nums2 = [1], n = 1
        int[] nums3 = {0};
        sol.merge(nums3, 0, new int[]{1}, 1);
        System.out.print("Example 3: ");
        printArray(nums3); // Expected: [1]
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }
}
