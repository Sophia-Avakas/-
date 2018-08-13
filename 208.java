class Trie {
    
    class TrieNode {
        public boolean isWord;
        public TrieNode[] neighbors;
        TrieNode() {
            neighbors = new TrieNode[26];
            isWord = false;
        }
    }
    
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.neighbors[index] == null) {
                cur.neighbors[index] = new TrieNode();
            }
            cur = cur.neighbors[index];  
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur= root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.neighbors[index] == null) {
                return false;
            }
            cur = cur.neighbors[index];
        }
        if (cur.isWord == true) return true;
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur= root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (cur.neighbors[index] == null) {
                return false;
            }
            cur = cur.neighbors[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */