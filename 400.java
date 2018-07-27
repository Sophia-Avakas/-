class Solution {
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;
        while (n > len * count) {
            n -= len * (int) count;
            len++;
            count = count * 10;
            start = start * 10;
        }
        int target = start + (n - 1) / len;
        int remainder = (n- 1) % len;
        return Character.getNumericValue(Integer.toString(target).charAt(remainder));
    }
}