class WordFilter {
    class TrieNode {
        TrieNode[] children;
        int weight;   
        public TrieNode() {
            children = new TrieNode[27];
            weight = 0;
        }
    }
    
    TrieNode root;
    public WordFilter(String[] words) {
        root = new TrieNode();   
        for (int weight = 0; weight < words.length; weight++) {
            String curr_word = words[weight] + "{";
            for (int i = 0; i < curr_word.length(); i++) {
                TrieNode curr = root;
                for (int j = i; j < 2 * curr_word.length() - 1; j++) {
                    char curr_c = curr_word.charAt(j % curr_word.length());
                    if (curr.children[curr_c - 'a'] == null) {
                        curr.children[curr_c - 'a'] = new TrieNode();
                    }
                    curr = curr.children[curr_c - 'a'];
                    curr.weight = weight;
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        TrieNode curr = root;
        String word = suffix + "{" + prefix;
        
        for (int i = 0; i < word.length(); i++) {
            char curr_c = word.charAt(i);
            if (curr.children[curr_c - 'a'] == null)
                return -1;
            curr = curr.children[curr_c - 'a'];
        }     
        return curr.weight;
    }
}