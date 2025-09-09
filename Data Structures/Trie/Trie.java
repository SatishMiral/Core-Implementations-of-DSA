// This Implementation Works for small case characters
public class Trie {
    // The Trie Node 
    private static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26]; // only 'a' to 'z'
            isEndOfWord = false;
        }
    }

    // Root of the Trie
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a new Word in Trie
    void insert(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            // If child dont exist
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            // move curr to its child
            curr = curr.children[index];
        }
        // End of word 
        curr.isEndOfWord = true;
    }

    // Search for a Word in Trie
    boolean search(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(curr.children[index] == null){
                return false;
            }
            curr = curr.children[index];
        }

        return curr.isEndOfWord;
    }

    // Search for Prefix
    boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char ch : prefix.toCharArray()){
            int index = ch - 'a';
            if(curr.children[index] == null){
                return false;
            }
            curr = curr.children[index];
        }

        return true;
    }

    // main method
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");

        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // true
        System.out.println(trie.startsWith("ap"));  // true
        System.out.println(trie.search("bat"));     // false
    }
}
