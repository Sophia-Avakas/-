class Solution {
    public int leastInterval(char[] tasks, int n) {
        int res = 0;
        if (tasks == null || tasks.length == 0) return res;
        int len = tasks.length;
        int[] count = new int[26];
        int max = 0;
        for (char ch : tasks) {
            count[ch - 'A']++;
            max = Math.max(max, count[ch - 'A']);
        }
        
        int count2 = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == max) {
                count2++;
            }
        }
        
        res = Math.max(len, (max - 1) * (n + 1) + count2);
        return res;
    }
}