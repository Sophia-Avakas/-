class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum = sum % k;
            Integer prev = map.get(sum);
            if (prev != null) {
                if (i - prev >= 2) {
                    return true;
                }
            }
            else map.put(sum, i);  
        }
     return false;
    }
}