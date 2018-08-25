class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null) return num2;
        if (num2 == null) return num1;
        int i = num1.length() - 1, j =num2.length() - 1;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                sum += num1.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += num2.charAt(j) - '0';
                j--;
            }
            sb.append(sum % 10);
            sum /= 10;
        }
        if (sum > 0) sb.append(sum);
        return sb.reverse().toString();
    }
}