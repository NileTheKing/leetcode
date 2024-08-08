class Trie {
    private class Node{
        private Node[] children;
        private boolean isEndOfWord;

        public Node(){
            children = new Node[26]; // constraints: word and prefix consist only of lowercase English letters.
            isEndOfWord = false;
        }

    }
    private Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null){
                //q. 인덱스로만 저장?
                node.children[index] = new Node();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        Node node = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(node.children[index] != null){
                node = node.children[index];
            }else{ return false;}
        }
        return node.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(char c : prefix.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null)
                return false;
            node = node.children[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */