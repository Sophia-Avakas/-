class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0, j = nums.length; //注意这里j不能等于nums.length - 1，会出错
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (target > nums[mid]) {
                i = mid + 1;
            }
            else {
                j = mid;
            }
        }
        return i;
    }
}