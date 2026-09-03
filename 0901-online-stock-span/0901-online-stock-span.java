import java.util.Stack;

class StockSpanner {

    // Each element stores:
    // [0] = stock price
    // [1] = span of that price
    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {

        // Today's price always contributes 1 day.
        int span = 1;

        // Remove previous prices that are
        // less than or equal to today's price.
        while (!stack.isEmpty() && stack.peek()[0] <= price) {

            // The removed price represents multiple days.
            // We can skip all of those days at once.
            span += stack.pop()[1];
        }

        // Store today's price and its calculated span.
        stack.push(new int[]{price, span});

        // Return today's stock span.
        return span;
    }
}