package src.week_37;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ValidBrackets {
    static Stack<Character> stack = new Stack<>();
    public static boolean isValid(String brackets) {
        try {
            for (int i = 0; i < brackets.length(); i++) {
                char ch = brackets.charAt(i);
                if (ch == '[' || ch == '(' || ch == '{')
                    stack.push(ch);
                else {
                    if (stack.isEmpty())
                        return false;
                    else {
                        char cmp = stack.pop();
                        if (ch == ']' && cmp != '[')
                            return false;
                        else if (ch == ')' && cmp != '(')
                            return false;
                        else if (ch == '}' && cmp != '{')
                            return false;
                    }
                }
            }
            return stack.isEmpty();
        } catch (Exception e) {
            throw new UnsupportedOperationException("Unsupported Operation");
        }
    }

    public static void main(String[] args) {
        System.out.println(ValidBrackets.isValid("[{()}]"));
        System.out.println(ValidBrackets.isValid("(]"));
        System.out.println(ValidBrackets.isValid("([)]"));
    }
}
