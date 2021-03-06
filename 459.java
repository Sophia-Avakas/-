class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null) return true;
        for (int i = s.length() / 2; i > 0; i--) {
            if (s.length() % i == 0) {
                int m =  s.length() / i;
                String str = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    sb.append(str);
                }
                if (s.toString().equals(s)) return true;
            }
        }
        return false;
    }
}