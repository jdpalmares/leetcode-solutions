

public class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int letter = word.charAt(i) - 'a';
            Node currentNode = node.chars[letter];
            if (currentNode != null)
                node = currentNode;
            else {
                node.chars[letter] = new Node();
                node = node.chars[letter];
            }
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        Node node = searchWord(word);
        if (node == null) return false;
        return node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node node = searchWord(prefix);
        return node != null;
    }

    private Node searchWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            Node currentNode = node.chars[word.charAt(i) - 'a'];
            if (currentNode == null) return null;
            node = currentNode;
        }
        return node;
    }

    private class Node {
        Node[] chars = new Node[26];
        boolean isWord;
    }
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */