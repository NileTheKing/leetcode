class StockSpanner {
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1; //default value

        while (!stack.isEmpty() && price >= stack.peek()[0]) {
            span += stack.pop()[1];
        }

        stack.push(new int[] {price, span});

        return span;
    }
}
/**
really typical monostack problem when you take a close look on the question.
 */
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */