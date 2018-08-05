class Solution {
    public String addBinary(String a, String b) {
        if (a == null) return b;
        if (b == null) return a;
        int i = a.length() - 1, j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            sb.append(sum % 2);
            sum /= 2;
        }
        if (sum == 1) sb.append(1);
        return sb.reverse().toString();
    }
}