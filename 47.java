class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        helper(nums, visited, new ArrayList<>(), res);
        return res;
    }
    
    private void helper(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && visited[i - 1])) continue;
            visited[i] = true;
            list.add(nums[i]);
            helper(nums, visited, list, res);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}