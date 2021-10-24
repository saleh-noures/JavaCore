package algorithms.tries.myway;

public class Trie {

    public static void insert(TrieNode currentNode, String s)
    {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (currentNode.getChildren().containsKey(c))
            {
                currentNode = currentNode.getChildren().get(c);
            } else {
                TrieNode node = new TrieNode(c);
                currentNode.getChildren().put(c,node);
                currentNode = node;
            }
            if (i == s.length() - 1)
                currentNode.setWord(true);
        }
    }

    public static boolean search(TrieNode currentNode, String s)
    {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(currentNode.getChildren().containsKey(c))
            {
             currentNode = currentNode.getChildren().get(c);
             if (i == s.length() - 1 && currentNode.isWord)
                 return true;
            } else {
                return false;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        TrieNode root = new TrieNode();

        insert(root, "Saleh");
        insert(root,"Omar");
        insert(root,"Adam");
        insert(root,"Ryan");
        insert(root,"Hadeel");
        insert(root,"Salem");
        insert(root,"Sale");

        System.out.println(search(root, "Saleh"));
        System.out.println(search(root, "Omir"));
        System.out.println(search(root, "Hadee"));
        System.out.println(search(root, "Adam"));

    }
}
