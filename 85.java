class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] height = new int[n + 1];
        height[n] = 0;
        int res = 0;
        for (int row = 0; row < m; row++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < n + 1; j++) {
                if (j < n) {
                    if (matrix[row][j] == '1') {
                        height[j]++;
                    }
                    else height[j] = 0;
                }
                if (stack.isEmpty() || height[j] >= height[stack.peek()]) {
                    stack.push(j);
                }
                else {
                    while (!stack.isEmpty() && height[j] < height[stack.peek()]) {
                        int cur = height[stack.pop()] * (stack.isEmpty() ? j : (j - stack.peek() - 1));
                        res = Math.max(res, cur);
                    }
                    stack.push(j);
                }
            }
        }
        return res;
    }
}