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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }
    
    private TreeNode helper(int preStart, int inStart int inEnd, int[] preorder, int[] inorder) {
        if (preStart >= preorder.length || inStart > inEnd) return null;
        TreeNode root = preorder[preStart];
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder(i) == root.val) {
                inIndex = i;
            }
        }
        
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + 1 + inIndex - inStart, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}