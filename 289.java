class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1 && (helper(board, i, j) == 2 || helper(board, i, j) == 3)) {
                    board[i][j] = 3; 
                }
                else if (board[i][j] == 0 && helper(board, i, j) == 3) {
                    board[i][j] = 2;
                }
            }
        }
        
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            board[i][j] >>= 1;
        }
      }
        
    }
    
    private int helper(int[][] board, int i, int j) {
        int res = 0;
        for (int x = Math.max(0, i - 1); x <= Math.min(i + 1, board.length - 1); x++) {
            for (int y = Math.max(0, j - 1); y <= Math.min(j + 1, board[0].length - 1); y++) {
                res += board[x][y] & 1;
            }
        }
        res -= board[i][j] & 1;
        return res;
    }
}