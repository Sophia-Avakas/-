/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) return null;
        int firstP = s.indexOf("(");
        int val = firstP == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, firstP));
        TreeNode root = new TreeNode(val);
        if (firstP == -1) return root;
        
        int count = 0;
        int start = firstP;
        for (int i = start; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') count++;
            else if (ch == ')') count--;
            if (count == 0) {
                if (start == firstP) {
                    root.left = str2tree(s.substring(start + 1, i));
                    start = i + 1;
                }
                else {
                    root.right = str2tree(s.substring(start + 1, i));
                }
            }
        }
        return root;
        
        
    }
}