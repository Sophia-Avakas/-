	class Solution {
    public void nextPermutation(int[] nums) {
        
        if (nums == null || nums.length < 2) return;
        int len = nums.length;
        int index = -1;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(nums, 0, len - 1);
            return;
        } 
        for (int i = len - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }
        reverse(nums, index + 1, len - 1);
    }
    
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}