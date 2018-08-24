class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length, maxsum = 0;
        int[] sum = new int[n + 1], left = new int[n], right = new int[n];
        int[] res = new int[3];
        
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        
         // DP for starting index of the left max sum interval
        int tot = sum[k] - sum[0];
        for (int i = k; i < n; i++) {
            if (sum[i + 1] - sum[i + 1 - k] > tot) {
                left[i] = i + 1 - k;
                tot = sum[i + 1] - sum[i + 1 - k];
            }
            else {
               left[i] = left[i - 1]; 
            }
        }
        
        // DP for starting index of the right max sum interval
       // caution: the condition is ">= tot" for right interval, and "> tot" for left interval
        right[n - k] = n - k;
        tot = sum[n] - sum[n - k];
        for (int i = n - k - 1; i >= 0; i--) {
            if (sum[i + k] - sum[i] >= tot) {
                right[i] = i;
                tot = sum[i + k] - sum[i];
            }
            else {
                right[i] = right[i + 1];
            }
        }
        
        for (int i = k; i <= n - 2 * k; i++) {
            int l = left[i - 1], r = right[i + k];
            tot = (sum[i + k] - sum[i]) + (sum[l + k] - sum[l]) + (sum[r + k] - sum[r]);
            if(tot > maxsum) {
                maxsum = tot;
                res[0] = l;
                res[1] = i;
                res[2] = r;
            }
        }
        return res;
    }
}