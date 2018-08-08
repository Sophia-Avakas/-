class Solution {
    public int nextGreaterElement(int n) {
        char[] number = (n + "").toCharArray();
        int i, j;
        for (i = number.length - 1; i > 0; i--) {
            if (number[i] > number[i - 1]) break;
        }
        if (i == 0) return -1;
        
        for (j = number.length - 1; j > i; j--) {
            if (number[j] > number[i - 1]) {
                break;
            }
        }
        
        char temp = number[i - 1];
        number[i - 1] = number[j];
        number[j] = temp;
        
        Arrays.sort(number, i, number.length);
        
        long val = Long.parseLong(new String(number));
        return (val <= Integer.MAX_VALUE) ? (int)val : -1;
    }
}