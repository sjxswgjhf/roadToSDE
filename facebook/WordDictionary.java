package facebook;

public class WordDictionary {

    class TrieNode{
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
        public TrieNode() {}
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new TrieNode();
    }


    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c-'a'] == null){
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode node = root;
        if(find(word, node, 0)){
            return true;
        }
        return false;
    }

    public boolean find(String word, TrieNode node, int idx){
        if(idx == word.length()){
            return node.isWord;
        }
        char c = word.charAt(idx);
        if(c == '.'){
            for(int i = 0; i < 26; i++){
                if(node.children[i] != null){
                    if(find(word, node.children[i], idx + 1)){
                        return true;
                    }
                }
            }
        }else{
            if(node.children[c-'a'] != null){
                return find(word, node.children[c-'a'], idx+1);
            }else{
                return false;
            }
        }
        return false;
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
