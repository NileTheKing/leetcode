class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        List<List<String>> ans = new ArrayList<>();
        //Arrays.sort(products);

        for(String product : products){
            trie.insert(product);
        }

        for(int i = 0; i < searchWord.length(); i++){
            List<String> currentString = new ArrayList<>();
            trie.prefixSuggest(searchWord.substring(0, i + 1), currentString);
            ans.add(currentString);
        }

        return ans;

        

    }

    static class Node{
        Map<Character, Node> child;
        boolean isEnd;

        public  Node(){
            child = new TreeMap<>();
            isEnd = false;
        }
    }

    static class Trie{
        Node rootNode;

        public Trie(){
            rootNode = new Node();
        }

        public void insert(String word){
            Node current = rootNode;
            for(char c : word.toCharArray()){
                current.child.putIfAbsent(c, new Node());
                current = current.child.get(c);
            }
            current.isEnd = true;
        }

        public void prefixSuggest(String prefix, List<String> currentString){//접두사로 시작하는 단어 3개
        //접두사까지 이동해서
        //단어찾기 실행
            Node currentNode = rootNode;
            StringBuilder sb = new StringBuilder(prefix);
            for(char c : prefix.toCharArray()){ //접두사의 마지막 노드(알파벳)으로 이동
                if(!currentNode.child.containsKey(c)){
                    return;
                }
                   
                currentNode = currentNode.child.get(c);
            }
            //접두사 단어 끝의 노드로 이동 완료

            //dfs로 단어 3개 찾고 ans에 List<String>을 add
            dfs(currentNode, currentString, sb);
        }

        //~로 시작하는 단어찾기
        public void dfs(Node currentNode, List<String> currentString, StringBuilder sb) {
            //입력된 string의 마지막 노드에 가서 dfs 3번까지 해서 ans에 추가.
            if(currentNode.isEnd){//끝에 도달하면 currentString에다가 sb를 toString해서 append하고, 단어가 끝이거나 
                //3개   append하면 리턴.
                currentString.add(sb.toString());
                //3개 찾으면
                if(currentString.size() == 3)
                    return;
            }

            for(Map.Entry<Character, Node> entry : currentNode.child.entrySet()){
                if (currentString.size() == 3) return;
                sb.append(entry.getKey());
                dfs(entry.getValue(), currentString, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        
    }
    

}

