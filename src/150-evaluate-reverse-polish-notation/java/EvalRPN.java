import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        int op1, op2;
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.add(stack.pop() + stack.pop());
            } else if (token.equals("/")) {
                op2 = stack.pop();
                op1 = stack.pop();
                stack.add(op1 / op2);
            } else if (token.equals("*")) {
                stack.add(stack.pop() * stack.pop());
            } else if (token.equals("-")) {
                op2 = stack.pop();
                op1 = stack.pop();
                stack.add(op1 - op2);
            } else {
                stack.add(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
