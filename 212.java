class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0) return res;
        int m = board.length, n = board[0].length;
        
        TrieNode root = buildTrie(words);
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, res, visited, root);
            }
        }
        return res;
    }
    
    private void dfs(char[][] board, int i, int j, List<String> res, boolean[][] visited, TrieNode root) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || root.children[board[i][j] - 'a'] == null) return;
        TrieNode node = root.children[board[i][j] - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null;  //注意这里不能停止搜索，而是要把word赋值为0
        }
        
        visited[i][j] = true;
        dfs(board, i - 1, j, res, visited, node);
        dfs(board, i + 1, j, res, visited, node);
        dfs(board, i, j - 1, res, visited, node);
        dfs(board, i, j + 1, res, visited, node);
        visited[i][j] = false;
    }
    
    class TrieNode {
        TrieNode[] children;
        String word;
        TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }
        return root;
    }
}