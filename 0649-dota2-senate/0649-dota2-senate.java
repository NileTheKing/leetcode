class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rad = new LinkedList<>(), dir = new LinkedList<>();
        int n = senate.length();
        // Add all senators to respect queue with index
        for (int i = 0; i < n; i++){
            if (senate.charAt(i) == 'R'){
                rad.add(i);
            } else {
                dir.add(i);
            }
        }
        // Use increasing n to keep track of position
        while (!rad.isEmpty() && !dir.isEmpty()){
            // Only "winner" stays in their queue
            if (rad.peek() < dir.peek()){
                rad.add(n++);
            } else {
                dir.add(n++);
            }
            rad.poll();
            dir.poll();
        }
        return (rad.isEmpty()) ? ("Dire") : ("Radiant");
    }
}