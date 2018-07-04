class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        long res = 0;
        str = str.trim();
        int sign = 1;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && str.charAt(i) == '-') {
                sign = -1;
                continue;
            }
            if (i == 0 && str.charAt(i) == '+') {
                sign = 1;
                continue;
            }
            if (!Character.isDigit(str.charAt(i))) {
                return (int) res * sign;
            }
            res = res * 10 + (str.charAt(i) - '0');
            if (sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && (-1) * res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            
        }
        return (int) res * sign;


    }
}