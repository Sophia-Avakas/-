class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();  
        helper(res, new StringBuilder(), s, 0);
        return res;
    }
    
    public void helper(List<String> res, StringBuilder sb, String s, int count) {
        if (count == 4) {
            if (s.length() == 0) {
                String str = sb.toString();
                res.add(str.substring(0, str.length() - 1));
            }
        }
        else {
            for (int i = 1; i <= 3; i++) {
                if (s.length() < i) return;
                String str = s.substring(0, i);
                if ((str.length() > 1 && str.charAt(0) == '0') || Integer.parseInt(str) > 255) continue;
                int len = sb.length();
                sb.append(str).append(".");
                helper(res, sb, s.substring(i), count + 1);
                sb.setLength(len);
            }
        }
    }
}