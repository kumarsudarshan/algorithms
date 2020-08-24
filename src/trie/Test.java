package trie;

public class Test {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("agile");
        trie.insert("kumar");
        trie.insert("kill");
        trie.insert("killed");
        trie.insert("killing");
        System.out.println(trie.search("kumar")); // true
        System.out.println(trie.search("kiled")); // false
        System.out.println(trie.startWith("kum")); // true
        System.out.println(trie.startWith("kumarsu")); // false
        System.out.println(trie.startWith("ag")); // true
    }
}
