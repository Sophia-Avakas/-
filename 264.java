class Solution {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            res[i] = Math.min(res[p2] * 2, Math.min(res[p3] * 3, res[p5] * 5));
            if (res[p2] * 2 == res[i]) p2++;
            if (res[p3] * 3 == res[i]) p3++;
            if (res[p5] * 5 == res[i]) p5++;
        }
        return res[n - 1];
    }
}