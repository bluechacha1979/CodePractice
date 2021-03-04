class WordDictionary {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean word;
        
        public TrieNode() {
            children = new TrieNode[26];
            word = false;
        }
    }

    /** Initialize your data structure here. */
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode temp = root;
        
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (temp == null || temp.children[curr - 'a'] == null) {
                temp.children[curr - 'a'] = new TrieNode();
            }
            temp = temp.children[curr - 'a'];
        }
        temp.word = true;
    }
    
    public boolean search(String word) {
        TrieNode temp = root;
        return helper(word, temp, 0);
    }
    
    public boolean helper(String word, TrieNode temp, int start) {
        if (start == word.length()) {
            return temp.word;
        }
        
        char curr = word.charAt(start);
        if (curr != '.') {
            if (temp.children[curr - 'a'] == null)
                return false;
            else {
                temp = temp.children[curr - 'a'];
                return helper(word, temp, start + 1);
            }
        }
        else {
            for (TrieNode child : temp.children) {
                if (child != null && helper(word, child, start + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}