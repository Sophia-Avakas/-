class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        if (s == null || s.length() == 0) return res;
        HashMap<Character, Integer> map = new HashMap<>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                j = Math.max(j, map.get(ch) + 1);
            }
            map.put(ch, i);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}