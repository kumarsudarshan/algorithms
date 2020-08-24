package trie;

public class Trie {
    TrieNode root;
    // initialize trie data structure
    public Trie(){
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word){
        // start searching from beginning
        TrieNode node = root;

        for(int i = 0; i < word.length();i++){
            // traversing each character
            char currentChar = word.charAt(i);
            if(!node.containsKey(currentChar)){ // if character not present in the node, then will add that character to that node else will just move to next pointer.
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar); // move to next node
        }
        node.setEnd(); // each character of the word traversed and inserted, so setting end as true to make valid word.
    }
    /** Returns if the word is in the trie. */
    public boolean search(String word){
        TrieNode node = root;
        for(int i = 0 ; i < word.length(); i++){
            char currentChar = word.charAt(i);
            if(!node.containsKey(currentChar)){
                return false;
            }
            node = node.get(currentChar);
        }
        return node.isEnd();
    }

    public boolean startWith(String prefix){
        TrieNode node = root;
        for(int i = 0 ;i < prefix.length(); i++){
            char currentChar = prefix.charAt(i);
            if(!node.containsKey(currentChar)){
                return false;
            }
            node = node.get(currentChar);
        }
        return true;
    }

}
