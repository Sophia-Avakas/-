public class Solution {
    public int countSubstrings(String s) {
        if (s == null) return 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countPalindromicSubstrings(s, i, i);
            count += countPalindromicSubstrings(s, i, i + 1);
        }
        
        return count;
    }
    
    public int countPalindromicSubstrings(String s, int begin, int end) {
        int count = 0;
        while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
            count++;
            begin--;
            end++;
        }
        return count;
    }
}