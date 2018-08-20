public class Solution {
     int maxDiameter = 0;
    
    public int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        maxDiameter = Math.max(left + right, maxDiameter);
        return Math.max(left, right) + 1;
    }
            
        
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDiameter;
    }
}