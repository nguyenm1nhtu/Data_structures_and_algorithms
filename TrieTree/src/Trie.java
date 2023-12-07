import java.util.HashMap;
import java.util.Map;

class Trie {

    static class TrieNode {
        private final Map<Character, TrieNode> children;
        private boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }

        public TrieNode getChild(char ch) {
            return children.get(ch);
        }

        public void setChild(char ch, TrieNode node) {
            children.put(ch, node);
        }

        public boolean containsChild(char ch) {
            return children.containsKey(ch);
        }

        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        public void setEndOfWord(boolean endOfWord) {
            isEndOfWord = endOfWord;
        }

        public Map<Character, TrieNode> getChildren() {
            return children;
        }
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChild(ch);
            if (node == null) {
                node = new TrieNode();
                current.setChild(ch, node);
            }
            current = node;
        }
        current.setEndOfWord(true);
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChild(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            TrieNode node = current.getChild(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return true;
    }

    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false; // The word doesn't exist in the Trie
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }

        char ch = word.charAt(index);
        TrieNode node = current.getChild(ch);
        if (node == null) {
            return false; // The word doesn't exist in the Trie
        }

        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty() && !current.isEndOfWord();
        }

        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insert words into the Trie
        trie.insert("apple");
        trie.insert("app");
        trie.insert("banana");

        // Search for words
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // true
        System.out.println(trie.search("orange"));  // false

        // Check if prefixes exist
        System.out.println(trie.startsWith("app"));     // true
        System.out.println(trie.startsWith("orange"));  // false

        // Delete words
        trie.delete("app");
        System.out.println(trie.search("app")); // false
        System.out.println(trie.startsWith("app")); // false
    }
}

