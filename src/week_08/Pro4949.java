package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * BOJ 4949 - 균형잡힌 세상
 * 문제 이해:
 */
public class Pro4949 {
    static StringBuilder sb = new StringBuilder();
    static String str;
    static Stack<Character> s = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            boolean flag = true;
            str = br.readLine();
            if (str.equals("."))
                break;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == '(' || ch == '[')
                    s.push(ch);
                else if (ch == ')') {
                    if (s.isEmpty() || s.pop() != '(') {
                        flag = false;
                        break;
                    }
                } else if (ch == ']') {
                    if (s.isEmpty() || s.pop() != '[') {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag && s.isEmpty())
                sb.append("yes").append("\n");
            else
                sb.append("no").append("\n");
            s.clear();
        }
        System.out.println(sb);
    }
}
