class Solution {
    public int maxProfit(int k, int[] prices) {
        int res = 0;
        int n = prices.length;
        if (n <= 0) return res;
        
        if (k >= n / 2) {
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    res += prices[i] - prices[i - 1];
                }
            }
            return res;
        }
        
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int localMax = dp[i - 1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], localMax + prices[j]);
                localMax = Math.max(localMax,dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }
}