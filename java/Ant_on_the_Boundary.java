// 3028. Ant on the Boundary
// An ant is on a boundary. It moves according to an array of non-zero integers 'nums'.
// For each element x in nums, if x > 0, the ant moves right by x units. If x < 0, the ant moves left by |x| units.
// Return the number of times the ant returns to the boundary.

class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int position = 0;
        int count = 0;
        for (int move : nums) {
            position += move;
            if (position == 0) {
                count++;
            }
        }
        return count;
    }
}
