class Solution {
    public int findPeakElement(int[] nums) {
        int i = 0;
        int j = nums.length - 1; 
        while (i + 1 < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            else if (nums[mid] > nums[mid - 1]) {
                i = mid + 1;
            }
            else {
                j = mid - 1;
            }
        }
        if (nums[i] < nums[j]) return j;
        else {
            return i;
        }
    }
}