class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;  
        helper(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void helper(int[][] image, int i, int j, int oldColor, int newColor) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || oldColor != image[i][j]) {
            return;
        }
        image[i][j] = newColor;
        helper(image, i - 1, j, oldColor, newColor);
        helper(image, i + 1, j, oldColor, newColor);
        helper(image, i, j - 1, oldColor, newColor);
        helper(image, i, j + 1, oldColor, newColor);

    }
    
}