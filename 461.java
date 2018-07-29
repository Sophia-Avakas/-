class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        int XOR = x ^ y;
        for (int i = 0; i < 32; i++) {
            res += (XOR >> i) & 1;
        }
        return res;
    }
}