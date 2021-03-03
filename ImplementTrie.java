class Trie {
    class TrieNode {
        TrieNode[] children;
        boolean word;
        
        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    /** Initialize your data structure here. */
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp = root;
        
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (temp.children[curr - 'a'] == null) {
                temp.children[curr - 'a'] = new TrieNode();
            }
            temp = temp.children[curr - 'a'];
        }
        temp.word = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = root;
        
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (temp == null || temp.children[curr - 'a'] == null) {
                return false;
            }
            temp = temp.children[curr - 'a'];
        }
        return temp.word;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        
        for (int i = 0; i < prefix.length(); i++) {
            char curr = prefix.charAt(i);
            if (temp == null || temp.children[curr - 'a'] == null) {
                return false;
            }
            temp = temp.children[curr - 'a'];
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