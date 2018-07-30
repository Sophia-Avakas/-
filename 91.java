class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; //注意这里很容易出错，不是0
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') dp[i] += dp[i - 1];
            if (i >=2 && s.charAt(i - 2) == '1') dp[i] += dp[i - 2];
            if (i >= 2 && s.charAt(i - 2) == '2' && s.charAt(i- 1) >= '0' && s.charAt(i - 1) <= '6') dp[i] += dp[i - 2];
        }
        return dp[n];
    }
}