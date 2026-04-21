//Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0;
        int h=nums.length-1;

        while(l<=h){
            int mid=l+(h-l)/2;

            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return l;
        
    }
}
