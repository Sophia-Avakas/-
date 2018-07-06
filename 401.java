class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[] nums1 = {8, 4, 2, 1};
        int[] nums2 = {32, 16, 8, 4, 2, 1};
        for (int i = 0; i <= num; i++) {
            List<Integer> hours = generateDigit(nums1, i);
            List<Integer> mins = generateDigit(nums2, num - i);
            for (int hour : hours) {
                if (hour > 11) continue;
                for (int min : mins) {
                    if (min >= 60) continue;
                    res.add(hour + ":" + (min < 10 ? "0" + min : min));
                }
            }
        }
        return res;
    }
    
    private List<Integer> generateDigit(int[] nums, int count) {
        List<Integer> res = new ArrayList<>();
        helper(nums, count, 0, 0, res);
        return res;
    }
    
    private void helper(int[] nums, int count, int i, int time, List<Integer> res) {
        if (count == 0) {
            res.add(time);
            return;
        }
        for (int j = i; j < nums.length; j++) {
            time += nums[j];
            helper(nums, count - 1, j + 1, time, res);
            time -= nums[j];
        }
    }
}