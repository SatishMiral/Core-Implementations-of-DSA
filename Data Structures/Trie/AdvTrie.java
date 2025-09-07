public class AdvTrie {
    // TrieNode class
    private static class TrieNode {
        TrieNode[] children;
        int ew; // Ends with
        int cp; // Common Prefix

        TrieNode() {
            children = new TrieNode[26];
            ew = 0;
            cp = 0;
        }

        boolean containsKey(char ch){
            return children[ch - 'a'] != null;
        }

        TrieNode get(char ch){
            return children[ch - 'a'];
        }

        void put(char ch, TrieNode node){
            children[ch - 'a'] = node;
        }

        void increaseEnd() {
            ew++;
        }

        void increasePrefix(){
            cp++;
        }

        void decreaseEnd(){
            ew--;
        }

        void decreasePrefix(){
            cp--;
        }
    }

    // Root of the Trie
    private final TrieNode root;

    // Intialize
    public AdvTrie(){
        root = new TrieNode();
    }

    // Insert a new Word in Trie
    void insert(String word){
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            // if the char is not there 
            if(!curr.containsKey(ch)){
                // add the char with a reference to next trieNode
                curr.put(ch, new TrieNode());
            }
            // got to that reference
            curr = curr.get(ch);
            curr.increasePrefix();
        }
        curr.increaseEnd();
    }

    // Count the words with with 'word'
    int countWordsEqualTo(String word){
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            if(!curr.containsKey(ch)){
                return 0;
            }
            curr = curr.get(ch);
        }
        return curr.ew;
    }

    // Count words starting with 'prefix'
    int countWordsStartingWith(String prefix){
        TrieNode curr = root;
        for(char ch : prefix.toCharArray()){
            if(!curr.containsKey(ch)){
                return 0;
            }
            curr = curr.get(ch);
        }
        return curr.cp;
    }

    // Delete the 'word from the trie'
    void delete(String word){
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            curr = curr.get(ch);
            curr.decreasePrefix();;
        }
        curr.decreaseEnd();;
    }

    public static void main(String[] args) {
        AdvTrie trie = new AdvTrie();
        trie.insert("apple");
        trie.insert("apple");
        trie.insert("apps");
        trie.insert("apps");
        trie.delete("apple");

        System.out.println(trie.countWordsStartingWith("app"));
        System.out.println(trie.countWordsEqualTo("apple"));
    }
}