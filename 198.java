class Solution {
    public int rob(int[] nums) {
        int rob = 0;
        int notrob = 0;
        for (int i = 0; i < nums.length; i++) {
            int oldRob = rob;
            rob = notrob + nums[i];
            notrob = Math.max(oldRob, notrob);
        }
        return Math.max(rob, notrob);  
    }
}