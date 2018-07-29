class Solution {
    
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        helper(digits, 0, res, new StringBuilder());
        return res;
    }
    
    private void helper(String digits, int start, List<String> res, StringBuilder sb) {
        if (start == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int digit = digits.charAt(start) - '0';
        for (int j = 0; j < map[digit].length(); j++) {
            sb.append(map[digit].charAt(j));
            helper(digits, start + 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        } 
    }
}