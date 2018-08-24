class Solution {
    public int findKthLargest(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int i = partition(nums, low, high);
            if (i == k - 1) break;
            if (i > k - 1) high = i - 1;
            else low = i + 1;
        }
        return nums[k - 1];
    }
    
    private int partition(int[] nums, int i, int j) {
        int pivot = nums[i];
        int low = i + 1;
        int high = j;
        while (low <= high) {
            if (pivot > nums[low] && pivot < nums[high]) {
                swap(nums, low, high);
                low++;
                high--;
            }
            else if (pivot <= nums[low]) {
                while (low <= high && pivot <= nums[low]) low++;
            }
            else {
                while (low <= high && pivot >= nums[high]) high--;
            }
        }
        swap(nums, i, high);
        return high;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}