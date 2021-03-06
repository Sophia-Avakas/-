class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                } 
                res = res + sign * sum;
            }
            else if (s.charAt(i) == '-') sign = -1;
            else if (s.charAt(i) == '+') sign = 1;
            else if (s.charAt(i) == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }
            else if (s.charAt(i) == ')') {
                sign = stack.pop();
                res = res * sign + stack.pop();
            }
        }
        return res;
    }
}