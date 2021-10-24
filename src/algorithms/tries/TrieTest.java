package algorithms.tries;

public class TrieTest {
    public static void main(String[] args) {
        Trie t = new Trie();

        t.insert("Saleh");
        t.insert("Omir");
        t.insert("Hadee");
        t.insert("Adam");

        System.out.println(t.search("Sale"));

    }
}
