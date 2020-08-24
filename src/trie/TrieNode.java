package trie;

public class TrieNode {

    private boolean isEnd;
    private TrieNode[] child;

    public TrieNode(){
        child = new TrieNode[26];
    }

    public boolean containsKey(char ch){
        return child[ch - 'a'] != null;
    }

    public TrieNode get(char ch){
        return child[ch - 'a'];
    }
    public void put(char ch, TrieNode node){
        child[ch - 'a'] = node;
    }

    public void setEnd(){
        isEnd = true;
    }

    public boolean isEnd(){
        return isEnd;
    }
}
