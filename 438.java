class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) return res;
        int[] chars = new int[256];
        for (char c : p.toCharArray()) {
            chars[c]++;
        }
        int left = 0, right = 0;
        int count = p.length();
        while (right < s.length()) {
            if (chars[s.charAt(right++)]-- > 0) count--;
            if (count == 0) res.add(left);
            if (right - left == p.length() && chars[s.charAt(left++)]++ >= 0) count++;
        }
        return res;
    }
}