package src.week_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 * BOJ 9012 - 괄호
 */
public class Pro9012 {
    static int T;
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String str = br.readLine();
            boolean flag = false;
            for (int i = 0; i < str.length(); i++) {
                char tmp = str.charAt(i);
                if (tmp == '(')
                    stack.add(tmp);
                else {
                    if (stack.isEmpty()) {
                        flag = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (!flag && stack.isEmpty())
                System.out.println("YES");
            else
                System.out.println("NO");
            stack.clear();
        }
    }
}
