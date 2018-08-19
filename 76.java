class Solution {
    public String minWindow(String s, String t) {
        int[] sa = new int[128];
        int[] ta = new int[128];
        for (int i = 0; i < t.length(); i++) {
            ta[t.charAt(i)]++;
        }
        int min = Integer.MAX_VALUE;
        String res = "";
        int start = 0, end = 0, count = 0;
        while (end < s.length()) {
            if (ta[s.charAt(end)] != 0) {
                if (ta[s.charAt(end)] > sa[s.charAt(end)]) {
                    count++;
                }
                sa[s.charAt(end)]++;
                
            }
            if (count == t.length()) {
                while (ta[s.charAt(start)] == 0 || sa[s.charAt(start)] > ta[s.charAt(start)]) {
                    if (sa[s.charAt(start)] > ta[s.charAt(start)]) {
                        sa[s.charAt(start)]--;
                    }
                    start++;
                }
                if (end - start + 1 < min) {
                    min = end - start + 1;
                    res = s.substring(start, end + 1);
                }
            }
            
            end++;
        }
        return res;
    }
}