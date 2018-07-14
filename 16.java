class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return nums[0] + nums[1];
        
        Arrays.sort(nums);
        int len = nums.length;
        int res = nums[0] + nums[1] + nums[len - 1];;
        
        for (int i = 0; i < len - 2; i++) {
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > target) right--;
                else left++;
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                
            }
        }
        return res;

    }
}