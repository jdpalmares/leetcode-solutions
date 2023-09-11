import java.util.Stack;

public class ValidParentheses {
    // intuition answer with stack data type and switch
    // public boolean isValid(String s) {
    // Stack<Character> validCheck = new Stack<>();
    // for (int i = 0; i < s.length(); i++) {
    // char c = s.charAt(i);
    // switch (c) {
    // case '(':
    // case '[':
    // case '{':
    // validCheck.push(c);
    // break;
    // case ')':
    // if (!validCheck.isEmpty() && validCheck.peek() == '(') {
    // validCheck.pop();
    // break;
    // } else {
    // return false;
    // }
    // case ']':
    // if (!validCheck.isEmpty() && validCheck.peek() == '[') {
    // validCheck.pop();
    // break;
    // } else {
    // return false;
    // }
    // case '}':
    // if (!validCheck.isEmpty() && validCheck.peek() == '{') {
    // validCheck.pop();
    // break;
    // } else {
    // return false;
    // }
    // default:
    // return false;
    // }
    // }
    // if (validCheck.size() > 0)
    // return false;
    // return true;
    // }

    // intuition answer with stack data type if else same performance
    // public boolean isValid(String s) {
    // Stack<Character> validCheck = new Stack<>();
    // for (int i = 0; i < s.length(); i++) {
    // char c = s.charAt(i);
    // if (c == '(' || c == '[' || c == '{') {
    // validCheck.push(c);
    // } else {
    // if (!validCheck.isEmpty()) {
    // if (c == ')' && validCheck.peek() == '(') {
    // validCheck.pop();
    // } else if (c == ']' && validCheck.peek() == '[') {
    // validCheck.pop();
    // } else if (c == '}' && validCheck.peek() == '{') {
    // validCheck.pop();
    // } else
    // return false;
    // } else
    // return false;
    // }
    // }
    // if (validCheck.size() > 0)
    // return false;
    // return true;
    // }

    // alternative answer shorter checking
    public boolean isValid(String s) {
        Stack<Character> ans = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                ans.push(')');
            else if (c == '{')
                ans.push('}');
            else if (c == '[')
                ans.push(']');
            else if (ans.isEmpty() || ans.pop() != c)
                return false;
        }
        return ans.isEmpty();
    }

    // alternative answer using hashmap
    // public boolean isValid(String s) {
    // HashMap<Character, Character> Hmap = new HashMap<Character, Character>();
    // Hmap.put(')', '(');
    // Hmap.put('}', '{');
    // Hmap.put(']', '[');
    // Stack<Character> stack = new Stack<Character>();
    // for (int idx = 0; idx < s.length(); idx++) {
    // if (s.charAt(idx) == '(' || s.charAt(idx) == '{' || s.charAt(idx) == '[') {
    // stack.push(s.charAt(idx));
    // continue;
    // }
    // if (stack.size() == 0 || Hmap.get(s.charAt(idx)) != stack.pop())
    // return false;
    // }
    // if (stack.size() == 0)
    // return true;
    // return false;
    // }
}
