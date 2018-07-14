class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, res = 0;
        
        for (int num : nums) {
            sum += num;
            res += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}