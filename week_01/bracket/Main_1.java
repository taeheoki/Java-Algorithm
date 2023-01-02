package week_01.bracket;

import java.util.Scanner;
import java.util.Stack;

public class Main_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Character> stack = new Stack();
        String s = sc.nextLine();

        for (int i = 0; i < N; i++) {
            s = sc.nextLine();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (stack.isEmpty()) stack.push(c);
                else {
                    if (c == ')') {
                        if (stack.peek() == '(') {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                    } else { // (s.charAt(j) == '(')
                        stack.push(c);
                    }
                }
            }
            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            stack.clear();
        }
    }
}
