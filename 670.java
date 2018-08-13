class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        
        int[] bucket = new int[10];
        for (int i = 0; i < digits.length; i++) {
            bucket[digits[i] - '0'] = i;
        }
        
        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (bucket[k] > i) {
                    char temp = digits[i];
                    digits[i] = digits[bucket[k]];
                    digits[bucket[k]] = temp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }
}