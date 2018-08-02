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
    int res = 0;
    int height = 0;
    public int findBottomLeftValue(TreeNode root) {
        helper(root, 1);
        return res;
    }
    
    private void helper(TreeNode root, int depth) {
        if (depth > height) {
            height = depth; 
            res = root.val;
        }
        if (root.left != null) helper(root.left, depth + 1);
        if (root.right != null) helper(root.right, depth + 1);
    }
}