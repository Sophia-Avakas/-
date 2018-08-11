
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int pStart, int pEnd) {
        if (pStart > pEnd) return null;
        TreeNode root = new TreeNode(postorder[pEnd]);
        int pos = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                pos = i;
                break;
            }
        }
        root.left = helper(inorder, postorder, inStart, pos - 1, pStart, pStart + pos - inStart - 1);
        root.right = helper(inorder, postorder, pos + 1, inEnd, pEnd - inEnd + pos, pEnd - 1);
        return root;
    }
}