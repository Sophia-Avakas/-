class Solution {
    public String countAndSay(int n) {
        String str = String.valueOf(1);
        for (int i = 2; i <= n; i++) {
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < str.length(); j++) {
                if (str.charAt(j) == str.charAt(j - 1)) count++;
                else {
                    sb.append(count);
                    sb.append(str.charAt(j - 1));
                    count = 1;
                } 
            }
            sb.append(count);
            sb.append(str.charAt(str.length() - 1));
            str = sb.toString();
        }
        return str;
    }
}