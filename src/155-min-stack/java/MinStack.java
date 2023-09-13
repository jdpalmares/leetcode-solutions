public class MinStack {
    // intuition Answer
    // Stack<Integer> stack;
    // PriorityQueue<Integer> sortedStack;

    // public MinStack() {
    // stack = new Stack<Integer>();
    // sortedStack = new PriorityQueue<>();
    // }

    // public void push(int val) {
    // stack.push(val);
    // sortedStack.add(val);
    // }

    // public void pop() {
    // int remVal = stack.pop();
    // sortedStack.remove(remVal);

    // }

    // public int top() {
    // return stack.peek();
    // }

    // public int getMin() {
    // Integer minVal = sortedStack.peek();
    // return minVal;
    // }

    // best answer found, create your own stack
    private Node stackNode;

    public MinStack() {
    }

    public void push(int val) {
        if (stackNode == null)
            stackNode = new Node(val, val, null);
        else
            stackNode = new Node(val, Math.min(val, stackNode.min), stackNode);
    }

    public void pop() {
        stackNode = stackNode.stackNext;
    }

    public int top() {
        return stackNode.val;
    }

    public int getMin() {
        return stackNode.min;
    }

    private class Node {
        int val;
        int min;
        Node stackNext;

        private Node(int val, int min, Node stackNext) {
            this.val = val;
            this.min = min;
            this.stackNext = stackNext;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */