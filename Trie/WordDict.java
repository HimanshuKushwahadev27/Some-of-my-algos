public class WordDict {
  
    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    private final TrieNode root;

    public WordDict() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, TrieNode node) {
        if (node == null) {
            return false;
        }

        if (index == word.length()) {
            return node.isEndOfWord;
        }

        char c = word.charAt(index);

        if (c == '.') {
            // Wildcard: try every possible child at this position
            for (TrieNode child : node.children) {
                if (searchHelper(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            // Regular character: follow the single matching path
            int childIndex = c - 'a';
            return searchHelper(word, index + 1, node.children[childIndex]);
        }
    }
}
