package algorithms.tries.myway;

import java.util.HashMap;

public class TrieNode {
    char c;
    boolean isWord;
    HashMap<Character,TrieNode> children = new HashMap<>();

    public TrieNode(){
            }
    public TrieNode (char chr){
        this.c = chr;
    }


    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(HashMap<Character, TrieNode> children) {
        this.children = children;
    }


    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }


}
