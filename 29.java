class Solution {
    public int divide(int dividend, int divisor) {
         if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;

        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int res = 0;

        while (dvd >= dvs) {
            int temp = dvs;
            int mul = 1;
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                mul <<= 1;
            }
            dvd -= temp;
            res += mul;
        }

        return (int) (sign * res);
        
    }
}