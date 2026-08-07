/**
 * LeetCode #66 - Plus One
 *
 * Problem:
 *   You are given a large integer represented as an integer array digits,
 *   where each digits[i] is the ith digit of the integer. The digits are
 *   ordered from most significant to least significant in left-to-right order.
 *   The large integer does not contain any leading 0's.
 *   Increment the large integer by one and return the resulting array of digits.
 *
 * Approach: Iterate from the last digit to the first
 *   - Start from the least significant digit and carry a 1.
 *   - If a digit is 9, set it to 0 and continue carrying.
 *   - Otherwise, increment the digit and return immediately.
 *   - If all digits were 9 (e.g. [9,9,9] -> [1,0,0,0]), prepend a 1.
 *
 * Time Complexity : O(n)
 * Space Complexity: O(1) (excluding the result array)
 */
public class Plus_one {
    public int[] plusOne(int[] digits) {
      for(int i=digits.length-1;i>=0;i--){
        if(digits[i]<9){
          digits[i]++;
          return digits;
        }
        digits[i]=0;
      }
      int[] result=new int[digits.length+1];
      result[0]=1;
      return result;
    }
}
