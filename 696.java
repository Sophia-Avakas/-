class Solution {
    public int countBinarySubstrings(String s) {
        int curLen = 1, preLen = 0;
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i- 1)) curLen++;
            else {
                preLen = curLen;
                curLen = 1;
            }
            if (preLen >= curLen) res++;
        }
        return res;
    }
}