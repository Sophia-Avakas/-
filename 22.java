class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", n, n);
        return res;
    }
    private void helper(List<String> list, String s, int left, int right) {
        if (left < 0 || right < 0 || left > right) return;
        if (left == 0 && right == 0) {
            list.add(s);
            return;
        }
        helper(list, s + '(', left - 1, right);
        helper(list, s + ')', left, right - 1);
    }
}