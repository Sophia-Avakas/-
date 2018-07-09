class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean helper(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || word.charAt(index) != board[i][j]) return false;
        
        visited[i][j] = true;
        if (helper(board, word, visited, i - 1, j, index + 1) || helper(board, word, visited, i + 1, j, index + 1) || helper(board, word, visited, i, j - 1, index + 1) || helper(board, word, visited, i, j + 1, index + 1)) 
            return true;
        visited[i][j] = false;
        return false;
    }
}