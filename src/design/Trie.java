package design;
/*
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings.
There are various applications of this data structure, such as autocomplete and spellchecker.
Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]
 */
public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("trie");
        trie.insert("design");
        System.out.println(trie.search("trie"));
        System.out.println(trie.startsWith("des"));
        System.out.println(trie.search("designtrie"));
        System.out.println(trie.startsWith("hek"));
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // insert a word in trie
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd(); // set end for the word
    }

    // search a word in trie
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                return false;
            }
            node = node.get(currentChar);
        }
        return node.isEnd();
    }

    // search with prefix in trie
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char currentChar = prefix.charAt(i);
            if (!node.containsKey(currentChar)) {
                return false;
            }
            node = node.get(currentChar);
        }
        return true;
    }
}

class TrieNode {

    TrieNode[] links;
    private final int size = 26;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[size];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}